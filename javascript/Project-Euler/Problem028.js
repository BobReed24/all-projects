function problem28(dim) {
  if (dim % 2 === 0) {
    throw new Error('Dimension must be odd')
  }
  if (dim < 1) {
    throw new Error('Dimension must be positive')
  }

  let result = 1
  for (let i = 3; i <= dim; i += 2) {
    
    result += 4 * i * i + 6 * (1 - i) 
  }
  return result
}

export { problem28 }
