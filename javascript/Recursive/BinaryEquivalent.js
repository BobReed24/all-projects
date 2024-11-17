export const binaryEquivalent = (num) => {
  if (num === 0 || num === 1) {
    return String(num)
  }
  return binaryEquivalent(Math.floor(num / 2)) + String(num % 2)
}
