import { mean } from './AverageMean.js'

function meanAbsoluteDeviation(data) {
  if (!Array.isArray(data)) {
    throw new TypeError('Invalid Input')
  }
  let absoluteSum = 0
  const meanValue = mean(data)
  for (const dataPoint of data) {
    absoluteSum += Math.abs(dataPoint - meanValue)
  }
  return absoluteSum / data.length
}

export { meanAbsoluteDeviation }
