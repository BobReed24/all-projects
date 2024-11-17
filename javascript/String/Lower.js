const lower = (str) => {
  if (typeof str !== 'string') {
    throw new TypeError('Invalid Input Type')
  }

  return str.replace(/[A-Z]/g, (char) =>
    String.fromCharCode(char.charCodeAt() + 32)
  )
}

export default lower
