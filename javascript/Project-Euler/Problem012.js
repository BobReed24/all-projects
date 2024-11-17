const getNumOfDivisors = (num) => {
  
  let numberOfDivisors = 0

  const sqrtNum = Math.sqrt(num)
  for (let i = 0; i <= sqrtNum; i++) {
    
    if (num % i === 0) {
      if (i === sqrtNum) {
        
        numberOfDivisors++
      } else {
        
        numberOfDivisors += 2
      }
    }
  }
  return numberOfDivisors
}

const firstTriangularWith500Divisors = () => {
  let triangularNum
  
  for (let n = 1; ; n++) {
    
    triangularNum = (1 / 2) * n * (n + 1)
    if (getNumOfDivisors(triangularNum) >= 500) return triangularNum
  }
}

export { firstTriangularWith500Divisors }
