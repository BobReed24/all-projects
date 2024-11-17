const numberOfDigit = (n) => Math.abs(n).toString().length

const numberOfDigitsUsingLog = (n) =>
  n === 0 ? 1 : Math.floor(Math.log10(Math.abs(n))) + 1

export { numberOfDigit, numberOfDigitsUsingLog }
