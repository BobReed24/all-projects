function ROT13(str) {
  if (typeof str !== 'string') {
    throw new TypeError('Argument should be string')
  }

  return str.replace(/[a-z]/gi, (char) => {
    const charCode = char.charCodeAt()

    if (/[n-z]/i.test(char)) {
      return String.fromCharCode(charCode - 13)
    }

    return String.fromCharCode(charCode + 13)
  })
}

export default ROT13
