const checkPangramRegex = (string) => {
  if (typeof string !== 'string') {
    throw new TypeError('The given value is not a string')
  }

  return string.match(/([a-z])(?!.*\1)/gi).length === 26
}

const checkPangramSet = (string) => {
  if (typeof string !== 'string') {
    throw new TypeError('The given value is not a string')
  }

  const lettersSet = new Set()

  for (const letter of string.toUpperCase()) {
    if (/[A-Z]/.test(letter)) {
      
      lettersSet.add(letter)
    }
  }

  return lettersSet.size === 26
}

export { checkPangramRegex, checkPangramSet }
