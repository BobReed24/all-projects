const Identity = (n) => {
  
  const res = []
  for (let i = 0; i < n; i++) {
    res[i] = []
    for (let j = 0; j < n; j++) {
      res[i][j] = i === j ? 1 : 0
    }
  }
  return res
}

const MatMult = (matrixA, matrixB) => {
  
  const n = matrixA.length
  const matrixC = []
  for (let i = 0; i < n; i++) {
    matrixC[i] = []
    for (let j = 0; j < n; j++) {
      matrixC[i][j] = 0
    }
  }
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      for (let k = 0; k < n; k++) {
        matrixC[i][j] += matrixA[i][k] * matrixB[k][j]
      }
    }
  }
  return matrixC
}

export const MatrixExponentiationRecursive = (mat, m) => {
  
  if (m === 0) {
    
    return Identity(mat.length)
  } else if (m % 2 === 1) {
    
    const tmp = MatrixExponentiationRecursive(mat, m - 1)
    
    return MatMult(tmp, mat)
  } else {
    
    const tmp = MatrixExponentiationRecursive(mat, m >> 1)
    
    return MatMult(tmp, tmp)
  }
}

