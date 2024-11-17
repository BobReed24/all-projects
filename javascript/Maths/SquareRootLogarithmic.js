const squareRootLogarithmic = (num) => {
  if (typeof num !== 'number') {
    throw new Error('Input data must be numbers')
  }
  let answer = 0
  let sqrt = 0
  let edge = num

  while (sqrt <= edge) {
    const mid = Math.trunc((sqrt + edge) / 2)
    if (mid * mid === num) {
      return mid
    } else if (mid * mid < num) {
      sqrt = mid + 1
      answer = mid
    } else {
      edge = mid - 1
    }
  }

  return answer
}

export { squareRootLogarithmic }
