const checkFlatCase = (varname) => {
  
  if (typeof varname !== 'string') {
    throw new TypeError('Argument is not a string.')
  }

  const pat = /^[a-z]*$/
  return pat.test(varname)
}

export { checkFlatCase }
