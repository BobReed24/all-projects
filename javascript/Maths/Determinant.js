const subMatrix = (matrix, i, j) => {
  let matrixSize = matrix[0].length
  if (matrixSize === 1) {
    return matrix[0][0]
  }
  let subMatrix = []
  for (let x = 0; x < matrixSize; x++) {
    if (x === i) {
      continue
    }
    subMatrix.push([])
    for (let y = 0; y < matrixSize; y++) {
      if (y === j) {
        continue
      }
      subMatrix[subMatrix.length - 1].push(matrix[x][y])
    }
  }
  return subMatrix
}

const isMatrixSquare = (matrix) => {
  let numRows = matrix.length
  for (let i = 0; i < numRows; i++) {
    if (numRows !== matrix[i].length) {
      return false
    }
  }
  return true
}

const determinant = (matrix) => {
  if (
    !Array.isArray(matrix) ||
    matrix.length === 0 ||
    !Array.isArray(matrix[0])
  ) {
    throw new Error('Input is not a valid 2D matrix.')
  }
  if (!isMatrixSquare(matrix)) {
    throw new Error('Square matrix is required.')
  }
  let numCols = matrix[0].length
  if (numCols === 1) {
    return matrix[0][0]
  }
  let result = 0
  let setIndex = 0
  for (let i = 0; i < numCols; i++) {
    result +=
      Math.pow(-1, i) *
      matrix[setIndex][i] *
      determinant(subMatrix(matrix, setIndex, i))
  }
  return result
}
export { determinant }
