const factorial = (n) => {
  if (!Number.isInteger(n) || n < 0) {
    throw new RangeError('Input should be a non-negative whole number')
  }

  if (n === 0) {
    return 1
  }

  return n * factorial(n - 1)
}

export { factorial }
