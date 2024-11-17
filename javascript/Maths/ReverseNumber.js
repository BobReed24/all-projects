const ReverseNumber = (number) => {
  
  if (typeof number !== 'number') {
    throw new TypeError('Argument is not a number.')
  }
  
  let reverseNumber = 0
  
  while (number > 0) {
    
    const lastDigit = number % 10
    
    reverseNumber = reverseNumber * 10 + lastDigit
    
    number = Math.floor(number / 10)
  }
  return reverseNumber
}

export { ReverseNumber }
