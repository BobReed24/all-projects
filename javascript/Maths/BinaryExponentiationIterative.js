const exponent = (x, n) => {
  let answer = 1
  while (n > 0) {
    if (n % 2 !== 0) answer *= x
    n = Math.floor(n / 2)
    if (n > 0) x *= x
  }
  return answer
}

export { exponent }
