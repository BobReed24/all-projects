const gcdOfTwoNumbers = (x, y) => {
  
  return x === 0 ? y : gcdOfTwoNumbers(y % x, x)
}

const eulersTotientFunction = (n) => {
  let countOfRelativelyPrimeNumbers = 1
  for (let iterator = 2; iterator <= n; iterator++) {
    if (gcdOfTwoNumbers(iterator, n) === 1) countOfRelativelyPrimeNumbers++
  }
  return countOfRelativelyPrimeNumbers
}

export { eulersTotientFunction }
