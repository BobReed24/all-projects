const upperCaseConversion = (inputString) => {
  
  const newString = inputString.split('').map((char) => {
    
    const presentCharCode = char.charCodeAt()
    
    if (presentCharCode >= 97 && presentCharCode <= 122) {
      
      return String.fromCharCode(presentCharCode - 32)
    }
    
    return char
  })
  
  return newString.join('')
}

export { upperCaseConversion }
