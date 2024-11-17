const CheckPascalCase = (VarName) => {
  
  if (typeof VarName !== 'string') {
    throw new TypeError('Argument is not a string.')
  }

  const pat = /^[A-Z][A-Za-z]*$/
  return pat.test(VarName)
}

export { CheckPascalCase }
