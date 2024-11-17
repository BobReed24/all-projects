function sumOfDigitsUsingString(number) {
  if (number < 0) number = -number

  return +number
    .toString()
    .split('')
    .reduce((a, b) => +a + +b)
}

function sumOfDigitsUsingLoop(number) {
  if (number < 0) number = -number
  let res = 0

  while (number > 0) {
    res += number % 10
    number = Math.floor(number / 10)
  }

  return res
}

function sumOfDigitsUsingRecursion(number) {
  if (number < 0) number = -number

  if (number < 10) return number

  return (number % 10) + sumOfDigitsUsingRecursion(Math.floor(number / 10))
}

export {
  sumOfDigitsUsingRecursion,
  sumOfDigitsUsingLoop,
  sumOfDigitsUsingString
}
