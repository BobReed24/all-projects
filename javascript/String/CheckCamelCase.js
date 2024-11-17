const checkCamelCase = (varName) => {
  
  if (typeof varName !== 'string') {
    throw new TypeError('Argument is not a string.')
  }

  const pat = /^[a-z][A-Za-z]*$/
  return pat.test(varName)
}

export { checkCamelCase }
