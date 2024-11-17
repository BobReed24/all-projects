const multiplesThreeAndFive = (num) => {
  if (num < 1) throw new Error('No natural numbers exist below 1')
  num -= 1
  let sum = 0

  const nSum = (num, frequency) => (frequency * (frequency + 1) * num) >> 1

  sum += nSum(3, Math.floor(num / 3))
  sum += nSum(5, Math.floor(num / 5))
  sum -= nSum(15, Math.floor(num / 15))
  return sum
}

export { multiplesThreeAndFive }
