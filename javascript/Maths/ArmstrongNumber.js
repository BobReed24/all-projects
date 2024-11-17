const armstrongNumber = (num) => {
  if (typeof num !== 'number' || num < 0) return false
  const numStr = num.toString()
  const sum = [...numStr].reduce(
    (acc, digit) => acc + parseInt(digit) ** numStr.length,
    0
  )
  return sum === num
}

export { armstrongNumber }
