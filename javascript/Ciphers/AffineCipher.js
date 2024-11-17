import { CoPrimeCheck } from '../Maths/CoPrimeCheck'

const key = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

function mod(n, m) {
  return ((n % m) + m) % m
}

function inverseMod(a, m) {
  for (let x = 1; x < m; x++) {
    if (mod(a * x, m) === 1) return x
  }
}

function isCorrectFormat(str, a, b) {
  if (typeof a !== 'number' || typeof b !== 'number') {
    throw new TypeError('Coefficient a, b should be number')
  }

  if (typeof str !== 'string') {
    throw new TypeError('Argument str should be String')
  }

  if (!CoPrimeCheck(a, 26)) {
    throw new Error(a + ' is not coprime of 26')
  }

  return true
}

function findCharIndex(char) {
  return char.toUpperCase().charCodeAt(0) - 'A'.charCodeAt(0)
}

function encrypt(str, a, b) {
  let result = ''
  if (isCorrectFormat(str, a, b)) {
    for (let x = 0; x < str.length; x++) {
      const charIndex = findCharIndex(str[x])
      if (charIndex < 0) result += '-1' + ' '
      else result += key.charAt(mod(a * charIndex + b, 26)) + ' '
    }
  }
  return result.trim()
}

function decrypt(str, a, b) {
  let result = ''
  if (isCorrectFormat(str, a, b)) {
    str = str.split(' ')
    for (let x = 0; x < str.length; x++) {
      if (str[x] === '-1') result += ' '
      else {
        const charIndex = findCharIndex(str[x])
        result += key[mod(inverseMod(a, 26) * (charIndex - b), 26)]
      }
    }
    return result
  }
}
export { encrypt, decrypt }
