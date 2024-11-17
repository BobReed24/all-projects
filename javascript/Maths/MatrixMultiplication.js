const matrixCheck = (matrix) => {
  let columnNumb
  for (let index = 0; index < matrix.length; index++) {
    if (index === 0) {
      columnNumb = matrix[index].length
    } else if (matrix[index].length !== columnNumb) {
      
    } else {
      return columnNumb
    }
  }
}

const twoMatricesCheck = (first, second) => {
  const [firstRowLength, secondRowLength, firstColLength, secondColLength] = [
    first.length,
    second.length,
    matrixCheck(first),
    matrixCheck(second)
  ]

  return (
    firstRowLength === secondColLength && secondRowLength === firstColLength
  )
}

const initiateEmptyArray = (first, second) => {
  if (twoMatricesCheck(first, second)) {
    const emptyArray = first.map(() => {
      return ['']
    })
    return emptyArray
  } else {
    return false
  }
}

export const matrixMult = (firstArray, secondArray) => {
  const multMatrix = initiateEmptyArray(firstArray, secondArray)
  for (let rm = 0; rm < firstArray.length; rm++) {
    const rowMult = []
    for (let col = 0; col < firstArray[0].length; col++) {
      rowMult.push(firstArray[rm][col])
    }
    for (let cm = 0; cm < firstArray.length; cm++) {
      const colMult = []
      for (let row = 0; row < secondArray.length; row++) {
        colMult.push(secondArray[row][cm])
      }
      let newNumb = 0
      for (let index = 0; index < rowMult.length; index++) {
        newNumb += rowMult[index] * colMult[index]
      }
      multMatrix[rm][cm] = newNumb
    }
  }
  return multMatrix
}

