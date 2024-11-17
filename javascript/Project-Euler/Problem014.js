const getCollatzSequenceLength = (num, seqLength) => {
  if (num === 1) {
    return seqLength
  } else {
    let newElement
    if (num % 2 === 0) {
      newElement = num / 2
    } else {
      newElement = 3 * num + 1
    }
    seqLength++
    return getCollatzSequenceLength(newElement, seqLength)
  }
}

export const findLongestCollatzSequence = (limit = 1000000) => {
  let startingPointForLargestSequence = 1
  let largestSequenceLength = 1
  for (let i = 2; i < limit; i++) {
    const currentSequenceLength = getCollatzSequenceLength(i, 1)
    if (currentSequenceLength > largestSequenceLength) {
      startingPointForLargestSequence = i
      largestSequenceLength = currentSequenceLength
    }
  }
  return startingPointForLargestSequence
}
