function sqrt(num, precision = 4) {
  if (!Number.isFinite(num)) {
    throw new TypeError(`Expected a number, received ${typeof num}`)
  }
  if (!Number.isFinite(precision)) {
    throw new TypeError(`Expected a number, received ${typeof precision}`)
  }
  let sqrt = 1
  for (let i = 0; i < precision; i++) {
    sqrt -= (sqrt * sqrt - num) / (2 * sqrt)
  }
  return sqrt
}

export { sqrt }
