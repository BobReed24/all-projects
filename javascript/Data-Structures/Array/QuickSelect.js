function QuickSelect(items, kth) {
  if (kth < 1 || kth > items.length) {
    throw new RangeError('Index Out of Bound')
  }

  return RandomizedSelect(items, 0, items.length - 1, kth)
}

function RandomizedSelect(items, left, right, i) {
  if (left === right) return items[left]

  const pivotIndex = RandomizedPartition(items, left, right)
  const k = pivotIndex - left + 1

  if (i === k) return items[pivotIndex]
  if (i < k) return RandomizedSelect(items, left, pivotIndex - 1, i)

  return RandomizedSelect(items, pivotIndex + 1, right, i - k)
}

function RandomizedPartition(items, left, right) {
  const rand = getRandomInt(left, right)
  Swap(items, rand, right)
  return Partition(items, left, right)
}

function Partition(items, left, right) {
  const x = items[right]
  let pivotIndex = left - 1

  for (let j = left; j < right; j++) {
    if (items[j] <= x) {
      pivotIndex++
      Swap(items, pivotIndex, j)
    }
  }

  Swap(items, pivotIndex + 1, right)

  return pivotIndex + 1
}

function getRandomInt(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min
}

function Swap(arr, x, y) {
  ;[arr[x], arr[y]] = [arr[y], arr[x]]
}

export { QuickSelect }
