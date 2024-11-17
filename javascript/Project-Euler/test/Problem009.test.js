import { findSpecialPythagoreanTriplet } from '../Problem009.js'

describe('Pythagorean Triplet', () => {
  
  test('the multiplication of the pythagorean triplet where a + b + c = 1000', () => {
    expect(findSpecialPythagoreanTriplet()).toBe(31875000)
  })
})
