const SQ5 = 5 ** 0.5 
const PHI = (1 + SQ5) / 2 

export const EvenFibonacci = (limit) => {
  if (limit < 1)
    throw new Error("Fibonacci sequence limit can't be less than 1")

  const highestIndex = Math.floor(Math.log(limit * SQ5) / Math.log(PHI))
  const n = Math.floor(highestIndex / 3)
  return Math.floor(
    ((PHI ** (3 * n + 3) - 1) / (PHI ** 3 - 1) -
      ((1 - PHI) ** (3 * n + 3) - 1) / ((1 - PHI) ** 3 - 1)) /
      SQ5
  )
}
