const maxCharacter = (str, ignorePattern) => {
  
  if (typeof str !== 'string') {
    throw new TypeError('Argument should be a string')
  } else if (!str) {
    throw new Error('The param should be a nonempty string')
  }

  const occurrenceMap = new Map()

  for (const char of str) {
    if (!ignorePattern?.test(char)) {
      occurrenceMap.set(char, occurrenceMap.get(char) + 1 || 1)
    }
  }

  let max = { char: '', occur: -Infinity }

  for (const [char, occur] of occurrenceMap) {
    if (occur > max.occur) {
      max = { char, occur }
    }
  }

  return max.char
}

export default maxCharacter
