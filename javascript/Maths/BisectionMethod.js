const findRoot = (a, b, func, numberOfIterations) => {
  
  const belongsToDomain = (x, f) => {
    const res = f(x)
    return !Number.isNaN(res)
  }
  if (!belongsToDomain(a, func) || !belongsToDomain(b, func))
    throw Error("Given interval is not a valid subset of function's domain")

  const hasRoot = (a, b, func) => {
    return func(a) * func(b) <= 0
  }
  if (hasRoot(a, b, func) === false) {
    throw Error(
      'Product f(a)*f(b) has to be negative so that Bolzano theorem is applied'
    )
  }

  const m = (a + b) / 2

  if (numberOfIterations === 0) {
    return m
  }

  const fm = func(m)
  const prod1 = fm * func(a)
  const prod2 = fm * func(b)

  if (prod2 <= 0) return findRoot(m, b, func, --numberOfIterations)

  return findRoot(a, m, func, --numberOfIterations)
}

export { findRoot }
