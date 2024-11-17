function zFunction(text) {
  const length = text.length
  const zArray = Array(length).fill(0)
  
  let left = 0
  let right = 0
  for (let index = 0; index < length; index++) {
    
    if (index <= right) {
      zArray[index] = Math.min(right - index + 1, zArray[index - left])
    }

    while (
      index + zArray[index] < length &&
      text[zArray[index]] === text[index + zArray[index]]
    ) {
      zArray[index]++
    }

    if (index + zArray[index] - 1 > right) {
      left = index
      right = index + zArray[index] - 1
    }
  }
  return zArray
}

export default zFunction
