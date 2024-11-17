import { isEven } from './IsEven'

const powLogarithmic = (x, n) => {
  if (n === 0) return 1
  const result = powLogarithmic(x, Math.floor(n / 2))
  if (isEven(n)) {
    return result * result
  }
  return result * result * x
}

export { powLogarithmic }
