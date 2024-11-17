export class Vector2 {
  constructor(x, y) {
    this.x = x
    this.y = y
  }

  add(vector) {
    const x = this.x + vector.x
    const y = this.y + vector.y
    return new Vector2(x, y)
  }

  subtract(vector) {
    const x = this.x - vector.x
    const y = this.y - vector.y
    return new Vector2(x, y)
  }

  multiply(scalar) {
    const x = this.x * scalar
    const y = this.y * scalar
    return new Vector2(x, y)
  }

  rotate(angleInDegrees) {
    const radians = (angleInDegrees * Math.PI) / 180
    const ca = Math.cos(radians)
    const sa = Math.sin(radians)
    const x = ca * this.x - sa * this.y
    const y = sa * this.x + ca * this.y
    return new Vector2(x, y)
  }
}

export function iterate(initialVectors, steps) {
  let vectors = initialVectors
  for (let i = 0; i < steps; i++) {
    vectors = iterationStep(vectors)
  }

  return vectors
}

function iterationStep(vectors) {
  const newVectors = []
  for (let i = 0; i < vectors.length - 1; i++) {
    const startVector = vectors[i]
    const endVector = vectors[i + 1]
    newVectors.push(startVector)
    const differenceVector = endVector.subtract(startVector).multiply(1 / 3)
    newVectors.push(startVector.add(differenceVector))
    newVectors.push(
      startVector.add(differenceVector).add(differenceVector.rotate(60))
    )
    newVectors.push(startVector.add(differenceVector.multiply(2)))
  }

  newVectors.push(vectors[vectors.length - 1])
  return newVectors
}
