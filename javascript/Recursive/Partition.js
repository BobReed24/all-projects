const canPartition = (nums, index = 0, target = 0) => {
  if (!Array.isArray(nums)) {
    throw new TypeError('Invalid Input')
  }

  const sum = nums.reduce((acc, num) => acc + num, 0)

  if (sum % 2 !== 0) {
    return false
  }

  if (target === sum / 2) {
    return true
  }

  if (index >= nums.length || target > sum / 2) {
    return false
  }

  const withCurrent = canPartition(nums, index + 1, target + nums[index])

  const withoutCurrent = canPartition(nums, index + 1, target)

  return withCurrent || withoutCurrent
}

export { canPartition }
