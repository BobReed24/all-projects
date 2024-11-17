const TwoSum = (nums, target) => {
  const numIndicesMap = new Map()
  for (let i = 0; i < nums.length; i++) {
    const complement = target - nums[i]
    if (numIndicesMap.has(complement)) return [numIndicesMap.get(complement), i]
    numIndicesMap.set(nums[i], i)
  }
  return []
}
export { TwoSum }
