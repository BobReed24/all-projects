const sieveOfEratosthenes = (n) => {
  
  const primes = new Array(n + 1)
  primes.fill(true) 
  primes[0] = primes[1] = false 
  const sqrtn = Math.ceil(Math.sqrt(n))
  for (let i = 2; i <= sqrtn; i++) {
    if (primes[i]) {
      for (let j = i * i; j <= n; j += i) {
        
        primes[j] = false
      }
    }
  }
  return primes
}

export { sieveOfEratosthenes }
