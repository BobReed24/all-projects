function sumOfNonAbundantNumbers(n = 28123) {
  const abundantNumbers = [] 
  const sumOfAbundantNumbers = {} 
  let sum = 0

  for (let i = 1; i <= n; i++) {
    if (isAbundant(i)) {
      abundantNumbers.push(i) 
      abundantNumbers.forEach((num) => {
        
        const sum = num + i
        sumOfAbundantNumbers[sum] = true
      })
    }
  }

  for (let i = 1; i <= n; i++) {
    if (!sumOfAbundantNumbers[i]) {
      
      sum += i
    }
  }

  return sum
}

function isAbundant(number) {
  let sum = 0
  for (let i = 1; i <= number / 2; i++) {
    if (number % i === 0) {
      
      sum += i 
    }
  }
  return sum > number
}

export { sumOfNonAbundantNumbers }
