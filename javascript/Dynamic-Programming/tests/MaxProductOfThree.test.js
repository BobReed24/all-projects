import { maxProductOfThree } from '../MaxProductOfThree'

describe('MaxProductOfThree', () => {
  it('expects to throw error for array with only 2 numbers', () => {
    expect(() => {
      maxProductOfThree([1, 3])
    }).toThrow('Triplet cannot exist with the given array')
  })

  it('expects to return 300 as the maximum product', () => {
    expect(maxProductOfThree([10, 6, 5, 3, 1, -10])).toBe(300)
  })

  it('expects to return 300 as the maximum product', () => {
    expect(maxProductOfThree([10, -6, 5, 3, 1, -10])).toBe(600)
  })
})

describe('MaxProductOfThree, random arrays of size 3 to 5', () => {
  
  function completeMaxThree(array) {
    let maximumProduct = null
    for (let i = 0; i < array.length - 2; i++) {
      for (let j = i + 1; j < array.length - 1; j++) {
        for (let k = j + 1; k < array.length; k++) {
          const currentProduct = array[i] * array[j] * array[k]
          if (maximumProduct === null || currentProduct > maximumProduct) {
            maximumProduct = currentProduct
          }
        }
      }
    }
    return maximumProduct
  }

  const maxValue = 4
  const minValue = -4
  const maxLength = 5
  const minLength = 3
  const numberOfRandomTests = 5000

  for (let i = 0; i < numberOfRandomTests; i++) {
    const arr = []
    
    const length = Math.floor(
      Math.random() * (maxLength - minLength) + minLength
    )

    for (let j = 0; j < length + 1; j++) {
      arr.push(Math.floor(Math.random() * (maxValue - minValue) + minValue))
    }

    const expectedProduct = completeMaxThree(arr)

    it(
      'Expect the array ' +
        arr.toString() +
        ' to return the maximum three product of ' +
        expectedProduct,
      () => {
        
        const actualProduct = maxProductOfThree(arr)

        expect(actualProduct === expectedProduct).toBeTruthy()
      }
    )
  }
})
