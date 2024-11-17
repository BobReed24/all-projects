const factorialDigitSum = (n = 100) => {
  
  const digits = [1]

  for (let x = 2; x <= n; x++) {
    let carry = 0
    for (let exp = 0; exp < digits.length; exp++) {
      const prod = digits[exp] * x + carry
      carry = Math.floor(prod / 10)
      digits[exp] = prod % 10
    }
    while (carry > 0) {
      digits.push(carry % 10)
      carry = Math.floor(carry / 10)
    }
  }

  return digits.reduce((prev, current) => prev + current, 0)
}

export { factorialDigitSum }
