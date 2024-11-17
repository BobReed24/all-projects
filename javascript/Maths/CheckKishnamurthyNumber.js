const factorial = (n) => {
  let fact = 1
  while (n !== 0) {
    fact = fact * n
    n--
  }
  return fact
}

const CheckKishnamurthyNumber = (number) => {
  
  if (typeof number !== 'number') {
    throw new TypeError('Argument is not a number.')
  }
  if (number === 0) {
    return false
  }
  
  let sumOfAllDigitFactorial = 0
  
  let newNumber = number
  
  while (newNumber > 0) {
    const lastDigit = newNumber % 10
    
    sumOfAllDigitFactorial += factorial(lastDigit)
    newNumber = Math.floor(newNumber / 10)
  }
  
  return sumOfAllDigitFactorial === number
}

export { CheckKishnamurthyNumber }
