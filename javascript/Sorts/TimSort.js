const Timsort = (array) => {
  
  const RUN = 32
  const n = array.length
  
  for (let i = 0; i < n; i += RUN) {
    InsertionSort(array, i, Math.min(i + RUN - 1, n - 1))
  }
  for (let size = RUN; size < n; size *= 2) {
    for (let left = 0; left < n; left += 2 * size) {
      const mid = left + size - 1
      const right = Math.min(left + 2 * size - 1, n - 1)
      Merge(array, left, mid, right)
    }
  }
  return array
}

const InsertionSort = (array, left, right) => {
  for (let i = left + 1; i <= right; i++) {
    const key = array[i]
    let j = i - 1
    while (j >= left && array[j] > key) {
      array[j + 1] = array[j]
      j--
    }
    array[j + 1] = key
  }
}

const Merge = (array, left, mid, right) => {
  if (mid >= right) return
  const len1 = mid - left + 1
  const len2 = right - mid
  const larr = Array(len1)
  const rarr = Array(len2)
  for (let i = 0; i < len1; i++) {
    larr[i] = array[left + i]
  }
  for (let i = 0; i < len2; i++) {
    rarr[i] = array[mid + 1 + i]
  }
  let i = 0
  let j = 0
  let k = left
  while (i < larr.length && j < rarr.length) {
    if (larr[i] < rarr[j]) {
      array[k++] = larr[i++]
    } else {
      array[k++] = rarr[j++]
    }
  }
  while (i < larr.length) {
    array[k++] = larr[i++]
  }
  while (j < rarr.length) {
    array[k++] = rarr[j++]
  }
}

const demo = () => {
  const size = 1000000
  const data = Array(size)
  for (let i = 0; i < size; i++) {
    data[i] = Math.random() * Number.MAX_SAFE_INTEGER
  }
  const isSorted = function (array) {
    const n = array.length
    for (let i = 0; i < n - 1; i++) {
      if (array[i] > array[i + 1]) return false
    }
    return true
  }
  Timsort(data)
  if (isSorted(data)) {
    return 'RIGHT'
  } else {
    return 'FAULTY'
  }
}

export { Timsort, demo }
