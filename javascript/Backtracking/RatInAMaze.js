function validateGrid(grid) {
  if (!Array.isArray(grid) || grid.length === 0)
    throw new TypeError('Grid must be a non-empty array')

  const allRowsHaveCorrectLength = grid.every(
    (row) => row.length === grid.length
  )
  if (!allRowsHaveCorrectLength) throw new TypeError('Grid must be a square')

  const allCellsHaveValidValues = grid.every((row) => {
    return row.every((cell) => cell === 0 || cell === 1)
  })
  if (!allCellsHaveValidValues)
    throw new TypeError('Grid must only contain 0s and 1s')
}

function isSafe(grid, x, y) {
  const n = grid.length
  return x >= 0 && x < n && y >= 0 && y < n && grid[y][x] === 1
}

function getPathPart(grid, x, y, solution, path) {
  const n = grid.length

  if (x === n - 1 && y === n - 1 && grid[y][x] === 1) {
    solution[y][x] = 1
    return path
  }

  if (!isSafe(grid, x, y)) return false

  if (solution[y][x] === 1) return false

  solution[y][x] = 1

  const right = getPathPart(grid, x + 1, y, solution, path + 'R')
  if (right) return right

  const down = getPathPart(grid, x, y + 1, solution, path + 'D')
  if (down) return down

  const up = getPathPart(grid, x, y - 1, solution, path + 'U')
  if (up) return up

  const left = getPathPart(grid, x - 1, y, solution, path + 'L')
  if (left) return left

  solution[y][x] = 0
  return false
}

function getPath(grid) {
  
  const n = grid.length

  const solution = []
  for (let i = 0; i < n; i++) {
    const row = Array(n)
    row.fill(0)
    solution[i] = row
  }

  return getPathPart(grid, 0, 0, solution, '')
}

export class RatInAMaze {
  constructor(grid) {
    
    validateGrid(grid)

    const solution = getPath(grid)

    if (solution !== false) {
      this.path = solution
      this.solved = true
    } else {
      this.path = ''
      this.solved = false
    }
  }
}
