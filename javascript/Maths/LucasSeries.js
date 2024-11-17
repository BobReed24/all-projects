function lucas(index) {
  
  if (index < 0) throw new TypeError('Index cannot be Negative')

  if (Math.floor(index) !== index)
    throw new TypeError('Index cannot be a Decimal')

  let a = 2
  let b = 1
  for (let i = 0; i < index; i++) {
    const temp = a + b
    a = b
    b = temp
  }
  return a
}

export { lucas }
