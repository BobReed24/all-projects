export const agm = (a, g) => {
  if (a === Infinity && g === 0) return NaN
  if (Object.is(a, -0) && !Object.is(g, -0)) return 0
  if (a === g) return a 
  let x 
  do {
    ;[a, g, x] = [(a + g) / 2, Math.sqrt(a * g), a]
  } while (a !== x && !isNaN(a))
  
  return a
}
