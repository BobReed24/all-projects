export default function binaryToDecimal(binaryString) {
  let decimalNumber = 0
  const binaryDigits = binaryString.split('').reverse() 
  binaryDigits.forEach((binaryDigit, index) => {
    decimalNumber += binaryDigit * Math.pow(2, index) 
  })
  return decimalNumber
}
