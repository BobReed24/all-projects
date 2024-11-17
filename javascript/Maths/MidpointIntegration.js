function integralEvaluation(N, a, b, func) {
  
  if (!Number.isInteger(N) || Number.isNaN(a) || Number.isNaN(b)) {
    throw new TypeError('Expected integer N and finite a, b')
  }
  if (N <= 0) {
    throw Error('N has to be >= 2')
  } 
  if (a > b) {
    throw Error('a must be less or equal than b')
  } 
  if (a === b) return 0 

  const h = (b - a) / N

  let xi = a 
  const pointsArray = []

  let temp
  for (let i = 0; i < N; i++) {
    temp = func(xi + h / 2)
    pointsArray.push(temp)
    xi += h
  }

  let result = h
  temp = pointsArray.reduce((acc, currValue) => acc + currValue, 0)

  result *= temp

  if (Number.isNaN(result)) {
    throw Error(
      'Result is NaN. The input interval does not belong to the functions domain'
    )
  }

  return result
}

export { integralEvaluation }
