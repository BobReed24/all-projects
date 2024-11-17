export const minesweeper = (matrix) => {
  const arrResult = []
  for (let x = 0; x < matrix.length; x++) {
    const arrLine = []
    for (let y = 0; y < matrix[x].length; y++) {
      let minesInCell = 0
      for (let xi = x - 1; xi <= x + 1; xi++) {
        if (matrix[xi] !== undefined) {
          for (let yi = y - 1; yi <= y + 1; yi++) {
            if ((xi !== x || yi !== y) && matrix[xi][yi] === true) {
              minesInCell++
            }
          }
        }
      }
      arrLine.push(minesInCell)
    }
    arrResult.push(arrLine)
  }
  return arrResult
}
