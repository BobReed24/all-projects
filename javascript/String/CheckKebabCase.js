const CheckKebabCase = (varName) => {
  
  if (typeof varName !== 'string') {
    throw new TypeError('Argument is not a string.')
  }

  const pat = /(\w+)-(\w)([\w-]*)/
  return pat.test(varName) && !varName.includes('_')
}

export { CheckKebabCase }
