const reverseWords = (str) => {
  if (typeof str !== 'string') {
    throw new TypeError('The given value is not a string')
  }

  return str
    .split(/\s+/) 
    .reduceRight((reverseStr, word) => `${reverseStr} ${word}`, '') 
    .trim() 
}

export default reverseWords
