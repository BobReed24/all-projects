const binarySearch = (arr, searchValue, low = 0, high = arr.length - 1) => {
  
  if (high < low || arr.length === 0) return -1

  const mid = low + Math.floor((high - low) / 2)

  if (arr[mid] === searchValue) {
    return mid
  }

  if (arr[mid] > searchValue) {
    return binarySearch(arr, searchValue, low, mid - 1)
  }

  return binarySearch(arr, searchValue, mid + 1, high)
}

export { binarySearch }
