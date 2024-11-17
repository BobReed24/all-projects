function NumberOfSubsetSum(array, sum) {
  if (sum < 0) {
    throw new Error('The sum must be non-negative.')
  }

  if (!array.every((num) => num > 0)) {
    throw new Error('All of the inputs of the array must be positive.')
  }
  const dp = [] 
  for (let i = 1; i <= sum; i++) {
    dp[i] = 0
  }
  dp[0] = 1 

  for (let i = 0; i < array.length; i++) {
    for (let j = sum; j >= array[i]; j--) {
      if (j - array[i] >= 0) {
        dp[j] += dp[j - array[i]]
      }
    }
  }
  return dp[sum]
}

export { NumberOfSubsetSum }
