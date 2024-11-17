export default class Circle {
  constructor(radius) {
    this.radius = radius
  }

  perimeter = () => {
    return this.radius * 2 * Math.PI
  }

  area = () => {
    return Math.pow(this.radius, 2) * Math.PI
  }
}
