const isPythagoreanTriplet = (a, b, c) =>
  Math.pow(a, 2) + Math.pow(b, 2) === Math.pow(c, 2)

export const findSpecialPythagoreanTriplet = () => {
  for (let a = 0; a < 1000; a++) {
    for (let b = a + 1; b < 1000; b++) {
      for (let c = b + 1; c < 1000; c++) {
        if (isPythagoreanTriplet(a, b, c) && a + b + c === 1000) {
          return a * b * c
        }
      }
    }
  }
}
