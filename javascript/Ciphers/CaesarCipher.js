const caesarCipher = (str, rotation) => {
  if (typeof str !== 'string' || !Number.isInteger(rotation) || rotation < 0) {
    throw new TypeError('Arguments are invalid')
  }

  const alphabets = new Array(26)
    .fill()
    .map((_, index) => String.fromCharCode(97 + index)) 

  const cipherMap = alphabets.reduce(
    (map, char, index) => map.set(char, alphabets[(rotation + index) % 26]),
    new Map()
  )

  return str.replace(/[a-z]/gi, (char) => {
    if (/[A-Z]/.test(char)) {
      return cipherMap.get(char.toLowerCase()).toUpperCase()
    }

    return cipherMap.get(char)
  })
}

export default caesarCipher
