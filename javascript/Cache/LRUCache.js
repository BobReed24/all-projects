class LRUCache {
  
  #capacity

  constructor(capacity) {
    if (!Number.isInteger(capacity) || capacity < 0) {
      throw new TypeError('Invalid capacity')
    }

    this.#capacity = ~~capacity
    this.misses = 0
    this.hits = 0
    this.cache = new Map()

    return Object.seal(this)
  }

  get info() {
    return Object.freeze({
      misses: this.misses,
      hits: this.hits,
      capacity: this.capacity,
      size: this.size
    })
  }

  get size() {
    return this.cache.size
  }

  get capacity() {
    return this.#capacity
  }

  set capacity(newCapacity) {
    if (newCapacity < 0) {
      throw new RangeError('Capacity should be greater than 0')
    }

    if (newCapacity < this.capacity) {
      let diff = this.capacity - newCapacity

      while (diff--) {
        this.#removeLeastRecentlyUsed()
      }
    }

    this.#capacity = newCapacity
  }

  #removeLeastRecentlyUsed() {
    this.cache.delete(this.cache.keys().next().value)
  }

  has(key) {
    key = String(key)

    return this.cache.has(key)
  }

  set(key, value) {
    key = String(key)
    
    if (this.size === this.capacity) {
      this.#removeLeastRecentlyUsed()
    }

    this.cache.set(key, value)
  }

  get(key) {
    key = String(key)
    
    if (this.cache.has(key)) {
      const value = this.cache.get(key)

      this.cache.delete(key)
      this.cache.set(key, value)

      this.hits++
      return value
    }

    this.misses++
    return null
  }

  parse(json) {
    const { misses, hits, cache } = JSON.parse(json)

    this.misses += misses ?? 0
    this.hits += hits ?? 0

    for (const key in cache) {
      this.set(key, cache[key])
    }

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

export default LRUCache