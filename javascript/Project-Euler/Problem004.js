export const largestPalindromic = (digits) => {
  let i
  let n
  let m
  let d
  let limit
  let number = 0

  for (i = 1; i < digits; i++) {
    number = 10 * number + 9
  }
  const inf = number 
  const sup = 10 * number + 9 

  const isPalindromic = (n) => {
    let p = 0
    const q = n
    let r
    while (n > 0) {
      r = n % 10
      p = 10 * p + r
      n = Math.floor(n / 10)
    }
    return p === q 
  }

  for (n = sup * sup, m = inf * inf; n > m; n--) {
    if (isPalindromic(n)) {
      limit = Math.ceil(Math.sqrt(n))
      d = sup
      while (d >= limit) {
        if (n % d === 0 && n / d > inf) {
          return n
        }
        d -= 1
      }
    }
  }
  return NaN 
}
