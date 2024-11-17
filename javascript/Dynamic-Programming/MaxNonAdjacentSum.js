function maximumNonAdjacentSum(nums) {
  
  if (nums.length < 0) return 0

  let maxIncluding = nums[0]
  let maxExcluding = 0

  for (const num of nums.slice(1)) {
    const temp = maxIncluding
    maxIncluding = maxExcluding + num
    maxExcluding = Math.max(temp, maxExcluding)
  }

  return Math.max(maxExcluding, maxIncluding)
}

export { maximumNonAdjacentSum }
