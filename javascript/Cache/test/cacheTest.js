export const fibonacciCache = (n, cache = null) => {
  if (cache) {
    const value = cache.get(n)

    if (value !== null) {
      return value
    }
  }

  if (n === 1 || n === 2) {
    return 1
  }

  const result = fibonacciCache(n - 1, cache) + fibonacciCache(n - 2, cache)

  cache && cache.set(n, result)

  return result
}

export const union = (...sets) => {
  return new Set(sets.reduce((flatArray, set) => [...flatArray, ...set], []))
}
