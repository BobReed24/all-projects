const Atbash = (str) => {
  if (typeof str !== 'string') {
    throw new TypeError('Argument should be string')
  }

  return str.replace(/[a-z]/gi, (char) => {
    const charCode = char.charCodeAt()

    if (/[A-Z]/.test(char)) {
      return String.fromCharCode(90 + 65 - charCode)
    }

    return String.fromCharCode(122 + 97 - charCode)
  })
}

export default Atbash
