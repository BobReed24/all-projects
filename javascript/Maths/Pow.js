const powLinear = (base, exponent) => {
  if (exponent < 0) {
    base = 1 / base
    exponent = -exponent
  }

  let result = 1

  while (exponent--) {
    
    result *= base
  }

  return result
}

const powFaster = (base, exponent) => {
  if (exponent < 2) {
    
    return base && ([1, base][exponent] || powFaster(1 / base, -exponent))
  }

  if (exponent & 1) {
    
    return base * powFaster(base * base, exponent >> 1) 
  }

  return powFaster(base * base, exponent / 2)
}

export { powLinear, powFaster }
