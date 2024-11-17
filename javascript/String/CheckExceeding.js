const checkExceeding = (str) => {
  if (typeof str !== 'string') {
    throw new TypeError('Argument is not a string')
  }

  const upperChars = str.toUpperCase().replace(/[^A-Z]/g, '') 

  const adjacentDiffList = []

  for (let i = 0; i < upperChars.length - 1; i++) {
    
    const { [i]: char, [i + 1]: adjacentChar } = upperChars

    if (char !== adjacentChar) {
      adjacentDiffList.push(
        Math.abs(char.charCodeAt() - adjacentChar.charCodeAt())
      )
    }
  }

  for (let i = 0; i < adjacentDiffList.length - 1; i++) {
    const { [i]: charDiff, [i + 1]: secondCharDiff } = adjacentDiffList

    if (charDiff > secondCharDiff) {
      return false
    }
  }

  return true
}

export { checkExceeding }
