export function LongestSubstringWithoutRepeatingCharacters(s) {
  let maxLength = 0
  let start = 0
  let end = 0
  const map = {}
  while (end < s.length) {
    if (map[s[end]] === undefined) {
      map[s[end]] = 1
      maxLength = Math.max(maxLength, end - start + 1)
      end++
    } else {
      while (s[start] !== s[end]) {
        delete map[s[start]]
        start++
      }
      delete map[s[start]]
      start++
    }
  }
  return maxLength
}

