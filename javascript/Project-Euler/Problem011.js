export function largestProductInAGrid(arr) {
  let max = 0
  const k = 4

  const dx = [1, 0, 1, -1]
  const dy = [0, 1, 1, 1]

  for (let y = 0; y < arr.length; y++) {
    for (let x = 0; x < arr[y].length; x++) {
      for (let d = 0; d < 4; d++) {
        let p = 1
        for (let i = 0; i < k; i++) {
          p *= get(arr, y + i * dy[d], x + i * dx[d])
        }
        max = Math.max(p, max)
      }
    }
  }
  return max
}

function get(arr, y, x) {
  if (y >= 0 && y < arr.length && x >= 0 && x < arr[y].length) {
    return arr[y][x]
  }

  return 0
}
