const checkPalindrome = (str) => {
  
  if (typeof str !== 'string') {
    return 'Not a string'
  }
  if (str.length === 0) {
    return 'Empty string'
  }
  
  const reversed = [...str].reverse().join('')
  return str === reversed ? 'Palindrome' : 'Not a Palindrome'
}

export { checkPalindrome }
