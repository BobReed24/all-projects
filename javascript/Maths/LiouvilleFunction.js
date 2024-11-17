import { PrimeFactors } from './PrimeFactors.js'
export const liouvilleFunction = (number) => {
  if (number <= 0) {
    throw new Error('Number must be greater than zero.')
  }
  return PrimeFactors(number).length % 2 === 0 ? 1 : -1
}
