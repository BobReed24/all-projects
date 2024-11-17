export const findSmallestMultiple = (maxDivisor) => {
  const divisors = Array.from({ length: maxDivisor }, (_, i) => i + 1)
  let num = maxDivisor + 1
  let result

  while (!result) {
    const isDivisibleByAll = divisors.every((divisor) => num % divisor === 0)
    if (isDivisibleByAll) result = num
    else num++
  }

  return result
}
