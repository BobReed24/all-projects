const AlternativeStringArrange = (str1, str2) => {
  
  if (typeof str1 !== 'string' || typeof str2 !== 'string') {
    return 'Not string(s)'
  }

  let outStr = ''

  const firstStringLength = str1.length
  
  const secondStringLength = str2.length
  
  const absLength =
    firstStringLength > secondStringLength
      ? firstStringLength
      : secondStringLength

  for (let charCount = 0; charCount < absLength; charCount++) {
    
    if (charCount < firstStringLength) {
      outStr += str1[charCount]
    }

    if (charCount < secondStringLength) {
      outStr += str2[charCount]
    }
  }

  return outStr
}

export { AlternativeStringArrange }
