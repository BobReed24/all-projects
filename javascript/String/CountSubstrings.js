const countSubstrings = (str, substring) => {
  if (typeof str !== 'string' || typeof substring !== 'string') {
    throw new TypeError('Argument should be string')
  }

  if (substring.length === 0) return str.length + 1

  let count = 0
  let position = str.indexOf(substring)

  while (position > -1) {
    count++
    position = str.indexOf(substring, position + 1)
  }

  return count
}

export { countSubstrings }
