const FibonacciIterative = (num) => {
  const isNeg = num < 0
  if (isNeg) num *= -1
  const sequence = [0]

  if (num >= 1) sequence.push(1)
  if (num >= 2) sequence.push(isNeg ? -1 : 1)

  for (let i = 2; i < num; i++) {
    sequence.push(
      isNeg ? sequence[i - 1] - sequence[i] : sequence[i] + sequence[i - 1]
    )
  }

  return sequence
}

const FibonacciGenerator = function* (neg) {
  let a = 0
  let b = 1
  yield a
  while (true) {
    yield b
    ;[a, b] = neg ? [b, a - b] : [b, a + b]
  }
}

const list = []
const FibonacciRecursive = (num) => {
  const isNeg = num < 0
  if (isNeg) num *= -1
  return (() => {
    switch (list.length) {
      case 0:
        list.push(0)
        return FibonacciRecursive(num)
      case 1:
        list.push(1)
        return FibonacciRecursive(num)
      case num + 1:
        return list
      default:
        list.push(list.at(-1) + list.at(-2))
        return FibonacciRecursive(num)
    }
  })().map((fib, i) => fib * (isNeg ? (-1) ** (i + 1) : 1))
}

const dict = new Map()
const FibonacciRecursiveDP = (stairs) => {
  const isNeg = stairs < 0
  if (isNeg) stairs *= -1

  if (stairs <= 1) return stairs

  if (dict.has(stairs))
    return (isNeg ? (-1) ** (stairs + 1) : 1) * dict.get(stairs)

  const res =
    FibonacciRecursiveDP(stairs - 1) + FibonacciRecursiveDP(stairs - 2)

  dict.set(stairs, res)

  return (isNeg ? (-1) ** (stairs + 1) : 1) * res
}

const FibonacciDpWithoutRecursion = (num) => {
  const isNeg = num < 0
  if (isNeg) num *= -1
  const table = [0]
  table.push(1)
  table.push(isNeg ? -1 : 1)
  for (let i = 2; i < num; ++i) {
    table.push(isNeg ? table[i - 1] - table[i] : table[i] + table[i - 1])
  }
  return table
}

const copyMatrix = (A) => {
  return A.map((row) => row.map((cell) => cell))
}

const Identity = (size) => {
  const isBigInt = typeof size === 'bigint'
  const ZERO = isBigInt ? 0n : 0
  const ONE = isBigInt ? 1n : 1
  size = Number(size)
  const I = Array(size)
    .fill(null)
    .map(() => Array(size).fill())
  return I.map((row, rowIdx) =>
    row.map((_col, colIdx) => {
      return rowIdx === colIdx ? ONE : ZERO
    })
  )
}

const matrixMultiply = (A, B) => {
  A = copyMatrix(A)
  B = copyMatrix(B)
  const isBigInt = typeof A[0][0] === 'bigint'
  const l = A.length
  const m = B.length
  const n = B[0].length 
  const C = Array(l)
    .fill(null)
    .map(() => Array(n).fill())
  for (let i = 0; i < l; i++) {
    for (let j = 0; j < n; j++) {
      C[i][j] = isBigInt ? 0n : 0
      for (let k = 0; k < m; k++) {
        C[i][j] += A[i][k] * B[k][j]
      }
    }
  }
  return C
}

const matrixExpo = (A, n) => {
  A = copyMatrix(A)
  const isBigInt = typeof n === 'bigint'
  const ZERO = isBigInt ? 0n : 0
  const TWO = isBigInt ? 2n : 2

  let result = Identity((isBigInt ? BigInt : Number)(A.length)) 
  while (n > ZERO) {
    if (n % TWO !== ZERO) result = matrixMultiply(result, A)
    n /= TWO
    if (!isBigInt) n = Math.floor(n)
    if (n > ZERO) A = matrixMultiply(A, A)
  }
  return result
}

const FibonacciMatrixExpo = (num) => {
  const isBigInt = typeof num === 'bigint'
  const ZERO = isBigInt ? 0n : 0
  const ONE = isBigInt ? 1n : 1
  
  if (num === ZERO) return num

  const isNeg = num < 0
  if (isNeg) num *= -ONE

  const A = [
    [ONE, ONE],
    [ONE, ZERO]
  ]

  const poweredA = matrixExpo(A, num - ONE) 
  let F = [[ONE], [ZERO]]
  F = matrixMultiply(poweredA, F)
  return F[0][0] * (isNeg ? (-ONE) ** (num + ONE) : ONE)
}

const sqrt5 = Math.sqrt(5)
const phi = (1 + sqrt5) / 2
const psi = (1 - sqrt5) / 2

const FibonacciUsingFormula = (n) => Math.round((phi ** n - psi ** n) / sqrt5)

export { FibonacciDpWithoutRecursion }
export { FibonacciIterative }
export { FibonacciGenerator }
export { FibonacciRecursive }
export { FibonacciRecursiveDP }
export { FibonacciMatrixExpo }
export { FibonacciUsingFormula }
