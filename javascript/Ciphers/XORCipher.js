const XORCipher = (str, key) => {
  if (typeof str !== 'string' || !Number.isInteger(key)) {
    throw new TypeError('Arguments type are invalid')
  }

  return str.replace(/./g, (char) =>
    String.fromCharCode(char.charCodeAt() ^ key)
  )
}

export default XORCipher
