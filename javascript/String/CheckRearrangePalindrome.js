export const palindromeRearranging = (str) => {
  
  if (typeof str !== 'string') {
    return 'Not a string'
  }
  
  if (!str) {
    return 'Empty string'
  }

  const charCounts = [...str].reduce((counts, char) => {
    counts[char] = counts[char] ? counts[char] + 1 : 1
    return counts
  }, {})
  
  return (
    Object.values(charCounts).filter((count) => count % 2 !== 0).length <= 1
  )
}

