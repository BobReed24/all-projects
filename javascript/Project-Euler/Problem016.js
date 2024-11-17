const powerDigitSum = function (n = 2, pow = 1000) {
  
  const digits = [n]
  let p = 1

  while (++p <= pow) {
    let carry = 0
    for (let exp = 0; exp < digits.length; exp++) {
      const prod = digits[exp] * n + carry
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

export { powerDigitSum }
