export function isPalindromeIterative(x) {
  if (typeof x !== 'string' && typeof x !== 'number') {
    throw new TypeError('Input must be a string or a number')
  }

  const string = x.toString()
  const length = string.length

  if (length === 1) return true

  for (let start = 0, end = length - 1; start < end; start++, end--) {
    
    if (string[start] !== string[end]) return false
  }
  
  return true
}
