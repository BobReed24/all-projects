const titleCaseConversion = (inputString) => {
  if (inputString === '') return ''
  
  const stringCollections = inputString.split(' ').map((word) => {
    let firstChar = ''
    
    const firstCharCode = word[0].charCodeAt()
    
    if (firstCharCode >= 97 && firstCharCode <= 122) {
      
      firstChar += String.fromCharCode(firstCharCode - 32)
    } else {
      
      firstChar += word[0]
    }
    const newWordChar = word
      .slice(1)
      .split('')
      .map((char) => {
        
        const presentCharCode = char.charCodeAt()
        
        if (presentCharCode >= 65 && presentCharCode <= 90) {
          
          return String.fromCharCode(presentCharCode + 32)
        }
        
        return char
      })
    
    return firstChar + newWordChar.join('')
  })
  
  return stringCollections.join(' ')
}

export { titleCaseConversion }
