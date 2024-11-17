const findHCF = (x, y) => {
  
  if (x < 1 || y < 1) {
    return 'Please enter values greater than zero.'
  }

  if (x !== Math.round(x) || y !== Math.round(y)) {
    return 'Please enter whole numbers.'
  }

  while (Math.max(x, y) % Math.min(x, y) !== 0) {
    if (x > y) {
      x %= y
    } else {
      y %= x
    }
  }

  return Math.min(x, y)
}

export { findHCF }
