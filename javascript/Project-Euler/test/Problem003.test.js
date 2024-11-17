import { largestPrime } from '../Problem003.js'

describe('Largest prime factor', () => {
  test('if the number is 13195', () => {
    expect(largestPrime(13195)).toBe(29)
  })
  
  test('if the number is 600851475143', () => {
    
    expect(largestPrime()).toBe(6857)
  })
})
