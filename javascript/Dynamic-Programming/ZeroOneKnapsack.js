const zeroOneKnapsack = (arr, n, cap, cache) => {
  
  if (cap === 0 || n === 0) {
    cache[n][cap] = 0
    return cache[n][cap]
  }

  if (cache[n][cap] !== -1) {
    return cache[n][cap]
  }

  let notPick = zeroOneKnapsack(arr, n - 1, cap, cache)

  let pick = 0
  if (arr[n - 1][0] <= cap) {
    
    pick =
      arr[n - 1][1] + zeroOneKnapsack(arr, n - 1, cap - arr[n - 1][0], cache)
  }

  cache[n][cap] = Math.max(pick, notPick) 
  return cache[n][cap]
}

const example = () => {
  
  let input = `1
    4 5
    1 8
    2 4
    3 0
    2 5
    2 3`

  input = input.trim().split('\n')
  input.shift()
  const length = input.length

  const output = []

  let i = 0
  while (i < length) {
    const cap = Number(input[i].trim().split(' ')[0])
    const currlen = Number(input[i].trim().split(' ')[1])
    let j = i + 1
    const arr = []
    while (j <= i + currlen) {
      arr.push(input[j])
      j++
    }
    const newArr = arr.map((e) => e.trim().split(' ').map(Number))
    const cache = []
    for (let i = 0; i <= currlen; i++) {
      const temp = []
      for (let j = 0; j <= cap; j++) {
        temp.push(-1)
      }
      cache.push(temp)
    }
    const result = zeroOneKnapsack(newArr, currlen, cap, cache)
    output.push(result)
    i += currlen + 1
  }

  return output
}

export { zeroOneKnapsack, example }
