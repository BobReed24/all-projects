function findMaxRecursion(arr, left, right) {
  const len = arr.length

  if (len === 0 || !arr) {
    return undefined
  }

  if (left >= len || left < -len || right >= len || right < -len) {
    throw new Error('Index out of range')
  }

  if (left === right) {
    return arr[left]
  }

  const mid = (left + right) >> 1

  const leftMax = findMaxRecursion(arr, left, mid)
  const rightMax = findMaxRecursion(arr, mid + 1, right)

  return Math.max(leftMax, rightMax)
}

export { findMaxRecursion }
