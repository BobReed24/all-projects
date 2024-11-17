export const hexagonalNumber = (number) => {
  if (number <= 0) {
    throw new Error('Number must be greater than zero.')
  }
  return number * (2 * number - 1)
}
