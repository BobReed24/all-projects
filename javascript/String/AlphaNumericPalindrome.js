const alphaNumericPalindrome = (str) => {
  if (typeof str !== 'string') {
    throw new TypeError('Argument should be string')
  }

  const newStr = str.replace(/[^a-z0-9]+/gi, '').toLowerCase()
  const midIndex = newStr.length >> 1 

  for (let i = 0; i < midIndex; i++) {
    if (newStr.at(i) !== newStr.at(~i)) {
      
      return false
    }
  }

  return true
}

export default alphaNumericPalindrome
