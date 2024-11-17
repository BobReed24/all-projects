const piEstimation = (iterations = 100000) => {
  let circleCounter = 0

  for (let i = 0; i < iterations; i++) {
    
    const x = Math.random()
    const y = Math.random()
    const radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))

    if (radius < 1) circleCounter += 1
  }

  const pi = (circleCounter / iterations) * 4
  return pi
}

export { piEstimation }
