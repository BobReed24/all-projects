const swap = (arr, i, j) => {
  const newArray = [...arr]

  ;[newArray[i], newArray[j]] = [newArray[j], newArray[i]] 

  return newArray
}

const permutations = (arr) => {
  const P = []
  const permute = (arr, low, high) => {
    if (low === high) {
      P.push([...arr])
      return P
    }
    for (let i = low; i <= high; i++) {
      arr = swap(arr, low, i)
      permute(arr, low + 1, high)
    }
    return P
  }
  return permute(arr, 0, arr.length - 1)
}

export { permutations }
