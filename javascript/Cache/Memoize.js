const memoize = (func, cache = new Map()) => {
  const jsonReplacer = (_, value) => {
    if (value instanceof Set) {
      
      return [...value]
    }

    if (value instanceof Map) {
      
      return Object.fromEntries(value)
    }

    return value
  }

  return (...args) => {
    
    const argsKey = JSON.stringify(args, jsonReplacer)

    if (cache.has(argsKey)) {
      return cache.get(argsKey)
    }

    const result = func(...args) 
    cache.set(argsKey, result)

    return result
  }
}

export { memoize }
