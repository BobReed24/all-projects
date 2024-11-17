import { ShorsAlgorithm } from '../ShorsAlgorithm'
import { fermatPrimeCheck } from '../FermatPrimalityTest'

describe("Shor's Algorithm", () => {
  const N = 10 
  const max = 35000 
  const min = 1000 

  for (let i = 0; i < N; i++) {
    while (true) {
      const num = Math.floor(Math.random() * max) + min
      
      if (fermatPrimeCheck(num, 1)) continue

      it('should find a non-trivial factor of ' + num, () => {
        const f = ShorsAlgorithm(num)

        expect(f).not.toEqual(1)
        expect(f).not.toEqual(num)

        expect(num % f).toEqual(0)
      })

      break
    }
  }
})
