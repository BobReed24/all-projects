const findMaxPointIndex = (
  array,
  rangeStartIndex,
  rangeEndIndex,
  originalLength
) => {
  
  const middleIndex =
    rangeStartIndex + parseInt((rangeEndIndex - rangeStartIndex) / 2)

  if (
    (middleIndex === 0 || array[middleIndex - 1] <= array[middleIndex]) &&
    (middleIndex === originalLength - 1 ||
      array[middleIndex + 1] <= array[middleIndex])
  ) {
    return middleIndex
  } else if (middleIndex > 0 && array[middleIndex - 1] > array[middleIndex]) {
    return findMaxPointIndex(
      array,
      rangeStartIndex,
      middleIndex - 1,
      originalLength
    )
  } else {
    
    return findMaxPointIndex(
      array,
      middleIndex + 1,
      rangeEndIndex,
      originalLength
    )
  }
}

const LocalMaximomPoint = (A) => findMaxPointIndex(A, 0, A.length - 1, A.length)

export { LocalMaximomPoint }
