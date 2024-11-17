const abs = (num) => {
  const validNumber = +num 

  if (Number.isNaN(validNumber) || typeof num === 'object') {
    throw new TypeError('Argument is NaN - Not a Number')
  }

  return validNumber < 0 ? -validNumber : validNumber 
}

export { abs }
