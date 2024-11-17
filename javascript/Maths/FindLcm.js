'use strict'

import { findHCF } from './FindHcf'

const findLcm = (num1, num2) => {
  
  if (num1 < 1 || num2 < 1) {
    throw Error('Numbers must be positive.')
  }

  if (num1 !== Math.round(num1) || num2 !== Math.round(num2)) {
    throw Error('Numbers must be whole.')
  }

  const maxNum = Math.max(num1, num2)
  let lcm = maxNum

  while (true) {
    if (lcm % num1 === 0 && lcm % num2 === 0) return lcm
    lcm += maxNum
  }
}

const findLcmWithHcf = (num1, num2) => {
  
  if (num1 < 1 || num2 < 1) {
    throw Error('Numbers must be positive.')
  }

  if (num1 !== Math.round(num1) || num2 !== Math.round(num2)) {
    throw Error('Numbers must be whole.')
  }

  return (num1 * num2) / findHCF(num1, num2)
}

export { findLcm, findLcmWithHcf }
