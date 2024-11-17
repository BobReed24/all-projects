'use strict'

const calcRange = (num) => {
  return [...Array(num).keys()].map((i) => i + 1)
}

const calcFactorial = (num) => {
  if (num === 0) {
    return 1
  }
  if (num < 0) {
    throw Error('Sorry, factorial does not exist for negative numbers.')
  }
  if (!num) {
    throw Error(
      'Sorry, factorial does not exist for null or undefined numbers.'
    )
  }
  if (num > 0) {
    const range = calcRange(num)
    const factorial = range.reduce((a, c) => a * c, 1)
    return factorial
  }
}

export { calcFactorial }
