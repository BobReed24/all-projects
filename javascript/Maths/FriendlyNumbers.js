export const FriendlyNumbers = (firstNumber, secondNumber) => {
  
  if (
    !Number.isInteger(firstNumber) ||
    !Number.isInteger(secondNumber) ||
    firstNumber === 0 ||
    secondNumber === 0 ||
    firstNumber === secondNumber
  ) {
    throw new Error('The two parameters must be distinct, non-null integers')
  }

  return abundancyIndex(firstNumber) === abundancyIndex(secondNumber)
}

function abundancyIndex(number) {
  return sumDivisors(number) / number
}

function sumDivisors(number) {
  let runningSumDivisors = number
  for (let i = 0; i < number / 2; i++) {
    if (Number.isInteger(number / i)) {
      runningSumDivisors += i
    }
  }
  return runningSumDivisors
}
