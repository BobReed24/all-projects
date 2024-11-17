import { extendedEuclideanGCD } from './ExtendedEuclideanGCD'

export class ModRing {
  constructor(MOD) {
    this.MOD = MOD
  }

  isInputValid = (arg1, arg2) => {
    if (!this.MOD) {
      throw new Error('Modulus must be initialized in the object constructor')
    }
    if (typeof arg1 !== 'number' || typeof arg2 !== 'number') {
      throw new TypeError('Input must be Numbers')
    }
  }
  
  add = (arg1, arg2) => {
    this.isInputValid(arg1, arg2)
    return ((arg1 % this.MOD) + (arg2 % this.MOD)) % this.MOD
  }

  subtract = (arg1, arg2) => {
    this.isInputValid(arg1, arg2)
    
    return ((arg1 % this.MOD) - (arg2 % this.MOD) + this.MOD) % this.MOD
  }

  multiply = (arg1, arg2) => {
    this.isInputValid(arg1, arg2)
    return ((arg1 % this.MOD) * (arg2 % this.MOD)) % this.MOD
  }

  divide = (arg1, arg2) => {
    
    return (extendedEuclideanGCD(arg1, arg2)[1] + this.MOD) % this.MOD
  }
}
