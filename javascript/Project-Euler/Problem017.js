const ones = [4, 3, 3, 5, 4, 4, 3, 5, 5, 4, 3, 6, 6, 8, 8, 7, 7, 9, 8, 8]

const tens = [6, 6, 5, 5, 5, 7, 6, 6]

const thousandLength = 8
const hundredLength = 7
const andLength = 3

const numberToWordLength = (n) => {
  let count = 0

  if (n < 20) {
    return ones[n]
  }

  if (n >= 20 && n < 100) {
    const unit = n % 10
    return tens[Math.floor(n / 10 - 2)] + (unit !== 0 ? ones[unit] : 0)
  }

  const hundred = Math.floor(n / 100) % 10
  const thousand = Math.floor(n / 1000)
  const sub = n % 100

  if (n > 999) {
    count += numberToWordLength(thousand) + thousandLength
  }

  if (hundred !== 0) {
    count += ones[hundred] + hundredLength
  }

  if (sub !== 0) {
    count += andLength + numberToWordLength(sub)
  }

  return count
}

const countNumberWordLength = (number) => {
  let count = 0

  if (Number.isNaN(parseInt(number))) {
    throw new Error('Invalid input, please provide valid number')
  }

  if (number < 1) {
    throw new Error('Please provide number greater that 1')
  }

  for (let i = 1; i <= number; i++) {
    count += numberToWordLength(i)
  }

  return count
}

export { countNumberWordLength }
