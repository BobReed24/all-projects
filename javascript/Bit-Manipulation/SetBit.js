export const setBit = (number, bitPosition) => {
  return number | (1 << bitPosition)
}
