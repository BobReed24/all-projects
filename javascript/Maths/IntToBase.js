const intToBase = (number, base) => {
  if (typeof number !== 'number' || typeof base !== 'number') {
    throw new Error('Input data must be numbers')
  }
  
  if (number === 0) {
    return '0'
  }
  let absoluteValue = Math.abs(number)
  let convertedNumber = ''
  while (absoluteValue > 0) {
    
    const lastDigit = absoluteValue % base
    convertedNumber = lastDigit + convertedNumber
    absoluteValue = Math.trunc(absoluteValue / base)
  }
  
  if (number < 0) {
    convertedNumber = '-' + convertedNumber
  }
  return convertedNumber
}

export { intToBase }
