const uniquePaths = (m, n) => {
  
  if (m === 1 || n === 1) return 1

  const paths = new Array(m).fill(1)

  for (let i = 1; i < n; i++) {
    for (let j = 1; j < m; j++) {
      
      paths[j] = paths[j - 1] + paths[j]
    }
  }
  return paths[m - 1]
}

export { uniquePaths }
