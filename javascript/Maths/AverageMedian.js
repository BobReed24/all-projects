const averageMedian = (sourceArrayOfNumbers) => {
  const numbers = [...sourceArrayOfNumbers].sort(sortNumbers)
  const numLength = numbers.length

  return numLength % 2 === 0
    ? (numbers[numLength / 2 - 1] + numbers[numLength / 2]) / 2
    : numbers[Math.floor(numLength / 2)]
}

const sortNumbers = (num1, num2) => num1 - num2

export { averageMedian }
