class Sudoku {
  
  constructor(board) {
    this.board = board
  }

  findEmptyCell() {
    
    for (let i = 0; i < 9; i++) {
      for (let j = 0; j < 9; j++) {
        if (this.board[i][j] === 0) return [i, j]
      }
    }
    return [-1, -1]
  }

  check([y, x], value) {
    
    for (let i = 0; i < 9; i++) {
      if (this.board[i][x] === value) return false
    }
    
    for (let i = 0; i < 9; i++) {
      if (this.board[y][i] === value) return false
    }

    const secRow = Math.floor(y / 3)
    const secCol = Math.floor(x / 3)
    for (let i = secRow * 3; i < secRow * 3 + 3; i++) {
      for (let j = secCol * 3; j < secCol * 3 + 3; j++) {
        if (y !== i && x !== j && this.board[i][j] === value) return false
      }
    }

    return true
  }

  solve() {
    const [y, x] = this.findEmptyCell()

    if (y === -1 && x === -1) return true

    for (let val = 1; val < 10; val++) {
      if (this.check([y, x], val)) {
        this.board[y][x] = val
        if (this.solve()) return true
        
        this.board[y][x] = 0
      }
    }
    
    return false
  }

  getSection(row, [start, end]) {
    return this.board[row].slice(start, end)
  }

  printBoard(output = (...v) => console.log(...v)) {
    
    for (let i = 0; i < 9; i++) {
      if (i % 3 === 0 && i !== 0) {
        output('- - - - - - - - - - - -')
      }
      output(
        ...this.getSection(i, [0, 3]),
        ' | ',
        ...this.getSection(i, [3, 6]),
        ' | ',
        ...this.getSection(i, [6, 9])
      )
    }
  }
}

export { Sudoku }
