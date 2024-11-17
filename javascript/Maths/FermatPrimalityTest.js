const modularExponentiation = (base, exponent, modulus) => {
  if (modulus === 1) return 0 

  let result = 1
  base %= modulus 

  while (exponent > 0) {
    
    if (exponent % 2 === 1) {
      result = (result * base) % modulus
      exponent--
    } else {
      exponent = exponent / 2 
      base = (base * base) % modulus
    }
  }

  return result
}

const fermatPrimeCheck = (n, numberOfIterations = 50) => {
  
  if (n <= 1 || n === 4) return false
  if (n <= 3) return true 

  for (let i = 0; i < numberOfIterations; i++) {
    
    const randomNumber = Math.floor(Math.random() * (n - 2) + 2)

    if (modularExponentiation(randomNumber, n - 1, n) !== 1) {
      return false
    }
  }

  return true
}

export { modularExponentiation, fermatPrimeCheck }
