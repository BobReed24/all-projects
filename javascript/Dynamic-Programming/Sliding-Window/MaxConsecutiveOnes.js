export const maxConsecutiveOnes = (nums) => {
  if (!nums.length) return 0

  let result = 0
  let k = 0

  for (
    let slowPointer = 0, fastPointer = 0;
    fastPointer < nums.length;
    fastPointer++
  ) {
    if (nums[fastPointer] === 0) k--

    while (k < 0) {
      if (nums[slowPointer] === 0) {
        k++
      }
      slowPointer++
    }
    result = Math.max(result, fastPointer - slowPointer + 1)
  }
  return result
}
