const countNumbersDivisible = (num1, num2, divider) => {
  if (
    typeof num1 !== 'number' ||
    typeof num2 !== 'number' ||
    typeof divider !== 'number'
  ) {
    throw new Error('Invalid input, please pass only numbers')
  }

  if (num1 > num2) {
    throw new Error(
      'Invalid number range, please provide numbers such that num1 < num2'
    )
  }

  if (divider > num2) {
    return 0
  }

  const num1Multiplier = num1 / divider
  const num2Multiplier = num2 / divider

  let divisibleCount = num2Multiplier - num1Multiplier

  if (num1 % divider === 0) {
    divisibleCount++
  }

  return Math.round(divisibleCount)
}

export { countNumbersDivisible }
