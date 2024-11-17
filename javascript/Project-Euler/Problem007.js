import { PrimeCheck } from '../Maths/PrimeCheck.js'

export const nthPrime = (n) => {
  if (n < 1) {
    throw new Error('Invalid Input')
  }

  let count = 0
  let candidateValue = 1
  while (count < n) {
    candidateValue++
    if (PrimeCheck(candidateValue)) {
      count++
    }
  }
  return candidateValue
}
