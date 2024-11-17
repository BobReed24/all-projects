export function eulerStep(xCurrent, stepSize, yCurrent, differentialEquation) {
  
  return yCurrent + stepSize * differentialEquation(xCurrent, yCurrent)
}

export function eulerFull(
  xStart,
  xEnd,
  stepSize,
  yStart,
  differentialEquation
) {
  
  const points = [{ x: xStart, y: yStart }]
  let yCurrent = yStart
  let xCurrent = xStart

  while (xCurrent < xEnd) {
    
    yCurrent = eulerStep(xCurrent, stepSize, yCurrent, differentialEquation)
    xCurrent += stepSize
    points.push({ x: xCurrent, y: yCurrent })
  }

  return points
}
