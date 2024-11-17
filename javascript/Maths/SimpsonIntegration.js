function integralEvaluation(N, a, b, func) {
  
  let isNEven = true
  if (N % 2 !== 0) isNEven = false

  if (!Number.isInteger(N) || Number.isNaN(a) || Number.isNaN(b)) {
    throw new TypeError('Expected integer N and finite a, b')
  }
  if (!isNEven) {
    throw Error('N is not an even number')
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
  for (let i = 0; i < N + 1; i++) {
    if (i === 0 || i === N) temp = func(xi)
    else if (i % 2 === 0) temp = 2 * func(xi)
    else temp = 4 * func(xi)

    pointsArray.push(temp)
    xi += h
  }

  let result = h / 3
  temp = pointsArray.reduce((acc, currValue) => acc + currValue, 0)

  result *= temp

  if (Number.isNaN(result)) {
    throw Error(
      "Result is NaN. The input interval doesn't belong to the functions domain"
    )
  }

  return result
}

export { integralEvaluation }
