const minimumEditDistance = (word1, word2) => {
  const n = word1.length
  const m = word2.length
  const dp = new Array(m + 1).fill(0).map((item) => [])

  for (let i = 0; i < n + 1; i++) {
    dp[0][i] = i
  }

  for (let i = 0; i < m + 1; i++) {
    dp[i][0] = i
  }

  for (let i = 1; i < m + 1; i++) {
    for (let j = 1; j < n + 1; j++) {
      const letter1 = word1[j - 1]
      const letter2 = word2[i - 1]

      if (letter1 === letter2) {
        dp[i][j] = dp[i - 1][j - 1]
      } else {
        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1
      }
    }
  }

  return dp[m][n]
}

export { minimumEditDistance }
