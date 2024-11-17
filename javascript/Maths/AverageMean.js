const mean = (nums) => {
  if (!Array.isArray(nums)) {
    throw new TypeError('Invalid Input')
  }

  return nums.reduce((sum, cur) => sum + cur, 0) / nums.length
}

export { mean }
