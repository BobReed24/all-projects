const generateMatrix = (rows, columns, filler = 0) => {
  const matrix = []
  for (let i = 0; i < rows; i++) {
    const submatrix = []
    for (let k = 0; k < columns; k++) {
      submatrix[k] = filler
    }
    matrix[i] = submatrix
  }
  return matrix
}

const uniquePaths2 = (obstacles) => {
  if (!Array.isArray(obstacles)) {
    throw new Error('Input data must be type of Array')
  }
  
  const rows = obstacles.length
  const columns = obstacles[0].length
  const grid = generateMatrix(rows, columns)
  
  for (let i = 0; i < rows; i++) {
    
    if (obstacles[i][0]) {
      break
    }
    grid[i][0] = 1
  }
  for (let j = 0; j < columns; j++) {
    if (obstacles[0][j]) {
      break
    }
    grid[0][j] = 1
  }
  
  for (let i = 1; i < rows; i++) {
    for (let j = 1; j < columns; j++) {
      grid[i][j] = obstacles[i][j] ? 0 : grid[i - 1][j] + grid[i][j - 1]
    }
  }
  return grid[rows - 1][columns - 1]
}

export { uniquePaths2 }
