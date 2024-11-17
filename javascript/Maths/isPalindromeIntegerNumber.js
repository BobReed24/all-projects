export function isPalindromeIntegerNumber(x) {
  if (typeof x !== 'number') {
    throw new TypeError('Input must be a integer number')
  }
  
  if (!Number.isInteger(x)) {
    return false
  }

  if (x < 0) return false

  let reversed = 0
  let num = x

  while (num > 0) {
    const lastDigit = num % 10
    reversed = reversed * 10 + lastDigit
    num = Math.floor(num / 10)
  }

  return x === reversed
}
