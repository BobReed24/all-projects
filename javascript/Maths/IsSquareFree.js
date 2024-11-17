import { PrimeFactors } from './PrimeFactors.js'
export const isSquareFree = (number) => {
  const primeFactorsArray = PrimeFactors(number)
  if (number <= 0) {
    throw new Error('Number must be greater than zero.')
  }
  return primeFactorsArray.length === new Set(primeFactorsArray).size
}
