export const latticePath = (gridSize) => {
  let paths
  for (let i = 1, paths = 1; i <= gridSize; i++) {
    paths = (paths * (gridSize + i)) / i
  }
  
  return paths
}

