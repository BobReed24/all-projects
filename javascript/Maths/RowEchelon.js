const tolerance = 0.000001

const isMatrixValid = (matrix) => {
  let numRows = matrix.length
  let numCols = matrix[0].length
  for (let i = 0; i < numRows; i++) {
    if (numCols !== matrix[i].length) {
      return false
    }
  }

  if (
    !Array.isArray(matrix) ||
    matrix.length === 0 ||
    !Array.isArray(matrix[0])
  ) {
    return false
  }
  return true
}

const checkNonZero = (currentRow, currentCol, matrix) => {
  let numRows = matrix.length
  for (let i = currentRow; i < numRows; i++) {
    
    if (!isTolerant(0, matrix[i][currentCol], tolerance)) {
      return true
    }
  }
  return false
}

const swapRows = (currentRow, withRow, matrix) => {
  let numCols = matrix[0].length
  let tempValue = 0
  for (let j = 0; j < numCols; j++) {
    tempValue = matrix[currentRow][j]
    matrix[currentRow][j] = matrix[withRow][j]
    matrix[withRow][j] = tempValue
  }
}

const selectPivot = (currentRow, currentCol, matrix) => {
  let numRows = matrix.length
  for (let i = currentRow; i < numRows; i++) {
    if (matrix[i][currentCol] !== 0) {
      swapRows(currentRow, i, matrix)
      return
    }
  }
}

const scalarMultiplication = (currentRow, factor, matrix) => {
  let numCols = matrix[0].length
  for (let j = 0; j < numCols; j++) {
    matrix[currentRow][j] *= factor
  }
}

const subtractRow = (currentRow, fromRow, matrix) => {
  let numCols = matrix[0].length
  for (let j = 0; j < numCols; j++) {
    matrix[fromRow][j] -= matrix[currentRow][j]
  }
}

const isTolerant = (a, b, tolerance) => {
  const absoluteDifference = Math.abs(a - b)
  return absoluteDifference <= tolerance
}

const rowEchelon = (matrix) => {
  
  if (!isMatrixValid(matrix)) {
    throw new Error('Input is not a valid 2D matrix.')
  }

  let numRows = matrix.length
  let numCols = matrix[0].length
  let result = matrix

  for (let i = 0, j = 0; i < numRows && j < numCols; ) {
    
    if (!checkNonZero(i, j, result)) {
      j++
      continue
    }

    selectPivot(i, j, result)
    let factor = 1 / result[i][j]
    scalarMultiplication(i, factor, result)

    for (let x = i + 1; x < numRows; x++) {
      factor = result[x][j]
      if (isTolerant(0, factor, tolerance)) {
        continue
      }
      scalarMultiplication(i, factor, result)
      subtractRow(i, x, result)
      factor = 1 / factor
      scalarMultiplication(i, factor, result)
    }
    i++
  }
  return result
}

export { rowEchelon }
