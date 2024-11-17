const fib = (N) => {
  if (N === 0) return [0, 1]
  const [a, b] = fib(Math.trunc(N / 2))
  const c = a * (b * 2 - a)
  const d = a * a + b * b
  return N % 2 ? [d, c + d] : [c, d]
}

const fastFibonacci = (N) => {
  if (!Number.isInteger(N)) {
    throw new TypeError('Input should be integer')
  }
  return fib(N)[0]
}

export { fastFibonacci }
