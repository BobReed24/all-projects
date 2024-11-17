export function kadaneAlgo(array) {
  let cumulativeSum = 0
  let maxSum = Number.NEGATIVE_INFINITY 
  for (let i = 0; i < array.length; i++) {
    cumulativeSum = cumulativeSum + array[i]
    if (maxSum < cumulativeSum) {
      maxSum = cumulativeSum
    } else if (cumulativeSum < 0) {
      cumulativeSum = 0
    }
  }
  return maxSum
  
}
