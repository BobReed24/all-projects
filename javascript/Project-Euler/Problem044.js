function problem44(k) {
  if (k < 1) {
    throw new Error('Invalid Input')
  }

  while (true) {
    k++
    const n = (k * (3 * k - 1)) / 2 

    for (let j = k - 1; j > 0; j--) {
      const m = (j * (3 * j - 1)) / 2 
      if (isPentagonal(n - m) && isPentagonal(n + m)) {
        
        return n - m 
      }
    }
  }
}

function isPentagonal(n) {
  const pent = (Math.sqrt(24 * n + 1) + 1) / 6
  return pent === Math.floor(pent)
}

export { problem44 }
