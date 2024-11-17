export function decExp(a, b, base = 10, exp = [], d = {}, dlen = 0) {
  if (base < 2 || base > 10) {
    throw new RangeError('Unsupported base. Must be in range [2, 10]')
  }

  if (a === 0) {
    return [0, [], undefined]
  }

  if (a === b && dlen === 0) {
    return [1, [], undefined]
  }

  d[a] = dlen++

  if (a < b) {
    exp.push(0)
    return decExp(a * base, b, base, exp, d, dlen)
  }

  const r = a % b
  const q = (a - r) / b

  exp.push(+q.toString(base))

  if (r === 0) {
    
    return [exp[0], exp.slice(1), undefined]
  }

  a = r * base

  if (a in d) {
    return [exp[0], exp.slice(1), d[a] - 1]
  }

  return decExp(a, b, base, exp, d, dlen)
}
