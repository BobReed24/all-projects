export const IsPowerOfTwo = (n) => {
  return n > 0 && (n & (n - 1)) === 0
}
