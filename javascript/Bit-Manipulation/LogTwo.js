export const logTwo = (n) => {
  let result = 0
  while (n >> 1) {
    n >>= 1
    result++
  }
  return result
}
