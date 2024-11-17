function BinaryCountSetBits(a) {
  'use strict'

  if (!Number.isInteger(a)) throw new TypeError('Argument not an Integer')

  let count = 0
  while (a) {
    a &= a - 1
    count++
  }

  return count
}

export { BinaryCountSetBits }
