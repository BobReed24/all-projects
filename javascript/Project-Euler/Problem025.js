function fibonacciIndex(t = 1000) {
  const digits = 10n ** BigInt(t - 1)
  let fib0 = BigInt(0)
  let fib1 = BigInt(1)
  let index = 1
  while (fib1 < digits) {
    
    const tempfib = fib1
    fib1 = fib1 + fib0
    fib0 = tempfib
    index += 1
  }
  return index
}

export { fibonacciIndex }
