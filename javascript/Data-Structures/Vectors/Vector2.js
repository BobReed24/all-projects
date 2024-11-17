class Vector2 {
  constructor(x, y) {
    this.x = x
    this.y = y
  }

  equalsExactly(vector) {
    return this.x === vector.x && this.y === vector.y
  }

  equalsApproximately(vector, epsilon) {
    return (
      Math.abs(this.x - vector.x) < epsilon &&
      Math.abs(this.y - vector.y) < epsilon
    )
  }

  length() {
    return Math.sqrt(this.x * this.x + this.y * this.y)
  }

  normalize() {
    const length = this.length()
    if (length === 0) {
      throw new Error('Cannot normalize vectors of length 0')
    }
    return new Vector2(this.x / length, this.y / length)
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

  distance(vector) {
    const difference = vector.subtract(this)
    return difference.length()
  }

  dotProduct(vector) {
    return this.x * vector.x + this.y * vector.y
  }

  rotate(angleInRadians) {
    const ca = Math.cos(angleInRadians)
    const sa = Math.sin(angleInRadians)
    const x = ca * this.x - sa * this.y
    const y = sa * this.x + ca * this.y
    return new Vector2(x, y)
  }

  angleBetween(vector) {
    return Math.atan2(vector.y, vector.x) - Math.atan2(this.y, this.x)
  }
}

export { Vector2 }
