export const squareDifference = (num = 100) => {
  let sumOfSquares = (num * (num + 1) * (2 * num + 1)) / 6
  let sums = (num * (num + 1)) / 2

  return sums ** 2 - sumOfSquares 
}
