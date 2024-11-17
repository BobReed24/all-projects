function CheckInput(a, b) {
  if (typeof a !== 'number' || typeof b !== 'number') {
    throw new TypeError('Arguments must be numbers')
  }
}

export function GetEuclidGCD(a, b) {
  CheckInput(a, b)
  a = Math.abs(a)
  b = Math.abs(b)
  while (b !== 0) {
    const rem = a % b
    a = b
    b = rem
  }
  return a
}

export function GetEuclidGCDRecursive(a, b) {
  CheckInput(a, b)
  a = Math.abs(a)
  b = Math.abs(b)
  if (b == 0) {
    return a
  }
  return GetEuclidGCDRecursive(b, a % b)
}
