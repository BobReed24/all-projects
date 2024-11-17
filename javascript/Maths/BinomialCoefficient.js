import { calcFactorial } from './Factorial'

export const findBinomialCoefficient = (n, k) => {
  if (typeof n !== 'number' || typeof k !== 'number') {
    throw Error('Type of arguments must be number.')
  }
  if (n < 0 || k < 0) {
    throw Error('Arguments must be greater than zero.')
  }
  let product = 1
  for (let i = n; i > k; i--) {
    product *= i
  }
  return product / calcFactorial(n - k)
}
