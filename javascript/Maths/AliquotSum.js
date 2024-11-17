function aliquotSum(input) {
  
  if (input < 0) throw new TypeError('Input cannot be Negative')

  if (Math.floor(input) !== input)
    throw new TypeError('Input cannot be a Decimal')

  if (input === 1) return 0

  let sum = 0
  for (let i = 1; i <= input / 2; i++) {
    if (input % i === 0) sum += i
  }

  return sum
}

export { aliquotSum }
