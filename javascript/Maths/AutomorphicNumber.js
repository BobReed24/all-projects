export const isAutomorphic = (n) => {
  if (typeof n !== 'number') {
    throw new Error('Type of n must be number')
  }
  if (!Number.isInteger(n)) {
    throw new Error('n cannot be a floating point number')
  }
  if (n < 0) {
    return false
  }

  let n_sq = n * n
  while (n > 0) {
    if (n % 10 !== n_sq % 10) {
      return false
    }
    n = Math.floor(n / 10)
    n_sq = Math.floor(n_sq / 10)
  }

  return true
}
