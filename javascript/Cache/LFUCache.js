class CacheNode {
  constructor(key, value, frequency) {
    this.key = key
    this.value = value
    this.frequency = frequency

    return Object.seal(this)
  }
}

class FrequencyMap extends Map {
  static get [Symbol.species]() {
    return Map
  } 
  get [Symbol.toStringTag]() {
    return ''
  }

  refresh(node) {
    const { frequency } = node
    const freqSet = this.get(frequency)
    freqSet.delete(node)

    node.frequency++

    this.insert(node)
  }

  insert(node) {
    const { frequency } = node

    if (!this.has(frequency)) {
      this.set(frequency, new Set())
    }

    this.get(frequency).add(node)
  }
}

class LFUCache {
  #capacity
  #frequencyMap

  constructor(capacity) {
    this.#capacity = capacity
    this.#frequencyMap = new FrequencyMap()
    this.misses = 0
    this.hits = 0
    this.cache = new Map()

    return Object.seal(this)
  }

  get capacity() {
    return this.#capacity
  }

  get size() {
    return this.cache.size
  }

  set capacity(newCapacity) {
    if (this.#capacity > newCapacity) {
      let diff = this.#capacity - newCapacity 

      while (diff--) {
        this.#removeCacheNode()
      }

      this.cache.size === 0 && this.#frequencyMap.clear()
    }

    this.#capacity = newCapacity
  }

  get info() {
    return Object.freeze({
      misses: this.misses,
      hits: this.hits,
      capacity: this.capacity,
      currentSize: this.size,
      leastFrequency: this.leastFrequency
    })
  }

  get leastFrequency() {
    const freqCacheIterator = this.#frequencyMap.keys()
    let leastFrequency = freqCacheIterator.next().value || null

    while (this.#frequencyMap.get(leastFrequency)?.size === 0) {
      leastFrequency = freqCacheIterator.next().value
    }

    return leastFrequency
  }

  #removeCacheNode() {
    const leastFreqSet = this.#frequencyMap.get(this.leastFrequency)
    
    const LFUNode = leastFreqSet.values().next().value

    leastFreqSet.delete(LFUNode)
    this.cache.delete(LFUNode.key)
  }

  has(key) {
    key = String(key) 

    return this.cache.has(key)
  }

  get(key) {
    key = String(key) 

    if (this.cache.has(key)) {
      const oldNode = this.cache.get(key)
      this.#frequencyMap.refresh(oldNode)

      this.hits++

      return oldNode.value
    }

    this.misses++
    return null
  }

  set(key, value, frequency = 1) {
    key = String(key) 

    if (this.#capacity === 0) {
      throw new RangeError('LFUCache ERROR: The Capacity is 0')
    }

    if (this.cache.has(key)) {
      const node = this.cache.get(key)
      node.value = value

      this.#frequencyMap.refresh(node)

      return this
    }

    if (this.#capacity === this.cache.size) {
      this.#removeCacheNode()
    }

    const newNode = new CacheNode(key, value, frequency)

    this.cache.set(key, newNode)
    this.#frequencyMap.insert(newNode)

    return this
  }

  parse(json) {
    const { misses, hits, cache } = JSON.parse(json)

    this.misses += misses ?? 0
    this.hits += hits ?? 0

    for (const key in cache) {
      const { value, frequency } = cache[key]
      this.set(key, value, frequency)
    }

    return this
  }

  clear() {
    this.cache.clear()
    this.#frequencyMap.clear()

    return this
  }

  toString(indent) {
    const replacer = (_, value) => {
      if (value instanceof Set) {
        return [...value]
      }

      if (value instanceof Map) {
        return Object.fromEntries(value)
      }

      return value
    }

    return JSON.stringify(this, replacer, indent)
  }
}

export default LFUCache
