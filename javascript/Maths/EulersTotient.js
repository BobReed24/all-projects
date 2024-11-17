export const EulersTotient = (n) => {
  
  let res = n
  for (let i = 2; i * i <= n; i++) {
    if (n % i === 0) {
      while (n % i === 0) {
        n = Math.floor(n / i)
      }
      
      res = res - Math.floor(res / i)
    }
  }
  if (n > 1) {
    res = res - Math.floor(res / n)
  }
  return res
}
