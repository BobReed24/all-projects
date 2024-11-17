const factorial = (n) => {
  if (n >= 0) {
    if (n === 0) {
      return 1
    } else {
      return n * factorial(n - 1)
    }
  } else {
    return NaN
  }
}

const permutation = (n, r) => {
  return factorial(n) / factorial(n - r)
}

const combination = (n, r) => {
  return factorial(n) / (factorial(r) * factorial(n - r))
}

export { factorial, permutation, combination }
