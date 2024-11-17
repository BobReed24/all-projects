export const nextPowerOfTwo = (n) => {
  if (n > 0 && (n & (n - 1)) === 0) return n
  let result = 1
  while (n > 0) {
    result = result << 1
    n = n >> 1
  }
  return result
}
