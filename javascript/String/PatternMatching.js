const checkIfPatternExists = (text, pattern) => {
  if (typeof text !== 'string' || typeof pattern !== 'string') {
    throw new TypeError('Given input is not a string')
  }
  const textLength = text.length 
  const patternLength = pattern.length 

  for (let i = 0; i <= textLength - patternLength; i++) {
    
    for (let j = 0; j < textLength; j++) {
      if (text[i + j] !== pattern[j]) break

      if (j + 1 === patternLength) {
        return `Given pattern is found at index ${i}`
      }
    }
  }
}

export { checkIfPatternExists }
