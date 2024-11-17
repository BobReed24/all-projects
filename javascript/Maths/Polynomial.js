class Polynomial {
  constructor(array) {
    this.coefficientArray = array 
    this.polynomial = '' 
    this.construct()
  }

  construct() {
    this.polynomial = this.coefficientArray
      .map((coefficient, exponent) => {
        if (coefficient === 0) {
          return '0'
        }
        if (exponent === 0) {
          return `(${coefficient})`
        } else if (exponent === 1) {
          return `(${coefficient}x)`
        } else {
          return `(${coefficient}x^${exponent})`
        }
      })
      .filter((x) => x !== '0')
      .reverse()
      .join(' + ')
  }

  display() {
    return this.polynomial
  }

  evaluate(value) {
    return this.coefficientArray.reduce((result, coefficient, exponent) => {
      return result + coefficient * Math.pow(value, exponent)
    }, 0)
  }
}

export { Polynomial }
