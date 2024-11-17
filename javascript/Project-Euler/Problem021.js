import { aliquotSum } from '../Maths/AliquotSum.js'

function problem21(n) {
  if (n < 2) {
    throw new Error('Invalid Input')
  }

  let result = 0
  for (let a = 2; a < n; ++a) {
    const b = aliquotSum(a) 
    
    if (b > a && aliquotSum(b) === a) {
      result += a + b
    }
  }
  return result
}

export { problem21 }
