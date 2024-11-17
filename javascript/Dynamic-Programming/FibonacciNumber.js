const fibonacci = (N) => {
  if (!Number.isInteger(N)) {
    throw new TypeError('Input should be integer')
  }

  let firstNumber = 0
  let secondNumber = 1

  for (let i = 1; i < N; i++) {
    const sumOfNumbers = firstNumber + secondNumber
    
    firstNumber = secondNumber
    secondNumber = sumOfNumbers
  }

  return N ? secondNumber : firstNumber
}

export { fibonacci }
