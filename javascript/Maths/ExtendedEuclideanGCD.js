const extendedEuclideanGCD = (arg1, arg2) => {
  if (typeof arg1 !== 'number' || typeof arg2 !== 'number')
    throw new TypeError('Not a Number')
  if (arg1 < 1 || arg2 < 1) throw new TypeError('Must be positive numbers')

  if (arg1 < arg2) {
    const res = extendedEuclideanGCD(arg2, arg1)
    const temp = res[1]
    res[1] = res[2]
    res[2] = temp
    return res
  }

  let r0 = arg1
  let r1 = arg2

  let s0 = 1
  let s1 = 0

  let t0 = 0
  let t1 = 1

  while (r1 !== 0) {
    const q = Math.floor(r0 / r1)

    const r2 = r0 - r1 * q
    const s2 = s0 - s1 * q
    const t2 = t0 - t1 * q

    r0 = r1
    r1 = r2
    s0 = s1
    s1 = s2
    t0 = t1
    t1 = t2
  }
  return [r0, s0, t0]
}

export { extendedEuclideanGCD }
