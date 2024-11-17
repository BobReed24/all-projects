const lengthOfLongestSubstring = (s) => {
  if (typeof s !== 'string') {
    throw new TypeError('Invalid Input Type')
  }
  let maxLength = 0
  let start = 0
  const charMap = new Map()
  for (let end = 0; end < s.length; end++) {
    if (charMap.has(s[end])) {
      start = Math.max(start, charMap.get(s[end]) + 1)
    }
    charMap.set(s[end], end)
    maxLength = Math.max(maxLength, end - start + 1)
  }
  return maxLength
}

export { lengthOfLongestSubstring }
