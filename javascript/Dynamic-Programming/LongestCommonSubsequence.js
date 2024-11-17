function longestCommonSubsequence(str1, str2) {
  const memo = new Array(str1.length + 1)
    .fill(null)
    .map(() => new Array(str2.length + 1).fill(null))

  function recursive(end1, end2) {
    if (end1 === -1 || end2 === -1) {
      return 0
    }

    if (memo[end1][end2] !== null) {
      return memo[end1][end2]
    }

    if (str1[end1] === str2[end2]) {
      memo[end1][end2] = 1 + recursive(end1 - 1, end2 - 1)
      return memo[end1][end2]
    } else {
      memo[end1][end2] = Math.max(
        recursive(end1 - 1, end2),
        recursive(end1, end2 - 1)
      )
      return memo[end1][end2]
    }
  }

  return recursive(str1.length - 1, str2.length - 1)
}

export { longestCommonSubsequence }
