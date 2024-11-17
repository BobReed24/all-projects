export const houseRobber = (nums) => {
  const length = nums.length

  if (length === 0) return 0
  if (length === 1) return nums[0]
  if (length === 2) return Math.max(nums[0], nums[1])

  const dp = Array(length) 
  dp[0] = nums[0]
  dp[1] = Math.max(nums[0], nums[1])

  for (let i = 2; i < length; i++) {
    dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1])
  }
  return dp[length - 1]
}
