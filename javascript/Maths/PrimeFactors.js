export const PrimeFactors = (n) => {
  
  const primeFactors = []
  for (let i = 2; i * i <= n; i++) {
    while (n % i === 0) {
      primeFactors.push(i)
      n = Math.floor(n / i)
    }
  }
  if (n > 1) {
    primeFactors.push(n)
  }
  return primeFactors
}
