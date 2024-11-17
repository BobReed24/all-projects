function compare(a, b) {
  
  if (a.x < b.x) return -1
  if (a.x === b.x && a.y < b.y) return -1
  return 1
}
function orientation(a, b, c) {
  
  const alpha = (b.y - a.y) / (b.x - a.x)
  const beta = (c.y - b.y) / (c.x - b.x)

  if (alpha > beta) return 1
  
  else if (beta > alpha) return -1
  
  return 0
}

function convexHull(points) {
  const pointsLen = points.length
  if (pointsLen <= 2) {
    throw new Error('Minimum of 3 points is required to form closed polygon!')
  }

  points.sort(compare)
  const p1 = points[0]
  const p2 = points[pointsLen - 1]

  const upperPoints = []
  const lowerPoints = []

  upperPoints.push(p1)
  lowerPoints.push(p1)

  for (let i = 1; i < pointsLen; i++) {
    if (i === pointsLen - 1 || orientation(p1, points[i], p2) !== -1) {
      let upLen = upperPoints.length

      while (
        upLen >= 2 &&
        orientation(
          upperPoints[upLen - 2],
          upperPoints[upLen - 1],
          points[i]
        ) === -1
      ) {
        upperPoints.pop()
        upLen = upperPoints.length
      }
      upperPoints.push(points[i])
    }
    if (i === pointsLen - 1 || orientation(p1, points[i], p2) !== 1) {
      let lowLen = lowerPoints.length
      while (
        lowLen >= 2 &&
        orientation(
          lowerPoints[lowLen - 2],
          lowerPoints[lowLen - 1],
          points[i]
        ) === 1
      ) {
        lowerPoints.pop()
        lowLen = lowerPoints.length
      }
      lowerPoints.push(points[i])
    }
  }
  const hull = []
  for (let i = 1; i < upperPoints.length - 1; i++) {
    hull.push(upperPoints[i])
  }
  for (let i = lowerPoints.length - 1; i >= 0; i--) {
    hull.push(lowerPoints[i])
  }

  return hull
}

export { convexHull }

