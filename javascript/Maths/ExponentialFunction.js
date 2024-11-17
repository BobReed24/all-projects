function exponentialFunction(power, n) {
  let output = 0
  let fac = 1
  if (isNaN(power) || isNaN(n) || n < 0) {
    throw new TypeError('Invalid Input')
  }
  if (n === 0) {
    return 1
  }
  for (let i = 0; i < n; i++) {
    output += power ** i / fac
    fac *= i + 1
  }
  return output
}

export { exponentialFunction }
