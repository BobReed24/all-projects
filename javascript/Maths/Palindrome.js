const PalindromeRecursive = (string) => {
  
  if (string.length < 2) return true

  if (string[0] !== string[string.length - 1]) {
    return false
  }

  return PalindromeRecursive(string.slice(1, string.length - 1))
}

const PalindromeIterative = (string) => {
  const _string = string
    .toLowerCase()
    .replace(/ /g, '')
    .replace(/,/g, '')
    .replace(/'.'/g, '')
    .replace(/:/g, '')
    .split('')

  while (_string.length > 1) {
    if (_string.shift() !== _string.pop()) {
      return false
    }
  }

  return true
}

const checkPalindrome = (str) =>
  str.replace(/\s/g, '') === str.replace(/\s/g, '').split('').reverse().join('')

export { PalindromeIterative, PalindromeRecursive, checkPalindrome }
