export default class Pyramid {
  constructor(bsl, height) {
    this.bsl = bsl
    this.height = height
  }

  baseArea = () => {
    return Math.pow(this.bsl, 2)
  }

  volume = () => {
    return (this.baseArea() * this.height) / 3
  }

  surfaceArea = () => {
    return (
      this.baseArea() +
      ((this.bsl * 4) / 2) *
        Math.sqrt(Math.pow(this.bsl / 2, 2) + Math.pow(this.height, 2))
    )
  }
}
