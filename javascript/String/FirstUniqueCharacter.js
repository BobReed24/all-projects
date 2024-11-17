const firstUniqChar = (str) => {
  if (typeof str !== 'string') {
    throw new TypeError('Argument should be string')
  }
  const count = new Map()

  for (const char of str) {
    if (!count[char]) {
      count[char] = 1
    } else {
      count[char]++
    }
  }
  for (let i = 0; i < str.length; i++) {
    if (count[str[i]] === 1) return i
  }
  return -1
}

export { firstUniqChar }
