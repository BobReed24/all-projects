const IsMaximumPoint = (array, index) => {
  
  if (index === 0) {
    return array[index] > array[index + 1]
    
  } else if (index === array.length - 1) {
    return array[index] > array[index - 1]
    
  } else {
    return array[index] > array[index + 1] && array[index] > array[index - 1]
  }
}

const CountLocalMaximumPoints = (array, startIndex, endIndex) => {
  
  if (startIndex === endIndex) {
    return IsMaximumPoint(array, startIndex) ? 1 : 0
  }

  const middleIndex = parseInt((startIndex + endIndex) / 2)
  return (
    CountLocalMaximumPoints(array, startIndex, middleIndex) +
    CountLocalMaximumPoints(array, middleIndex + 1, endIndex)
  )
}

const NumberOfLocalMaximumPoints = (A) =>
  CountLocalMaximumPoints(A, 0, A.length - 1)

export { NumberOfLocalMaximumPoints }
