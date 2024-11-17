function generateSubSets(inputArray) {
  if (!Array.isArray(inputArray)) {
    throw new Error('Provided input is not an array')
  }
  if (inputArray.length > 32) {
    throw new RangeError('Error size should be less than equal to 32')
  }
  let arrayLength = inputArray.length
  let subSets = []
  
  for (let i = 0; i < 1 << arrayLength; i++) {
    let subSet = []
    for (let j = 0; j < arrayLength; j++) {
      
      if (i & (1 << j)) {
        subSet.push(inputArray[j])
      }
    }
    subSets.push(subSet)
  }
  return subSets
}

export { generateSubSets }
