function minimum(a, b, c) {
  if (a < b && a < c) {
    return a
  } else if (b < a && b < c) {
    return b
  } else {
    return c
  }
}

function costOfSubstitution(x, y) {
  return x === y ? 0 : 1
}

function calculateLevenshteinDp(x, y) {
  const dp = new Array(x.length + 1)
  for (let i = 0; i < x.length + 1; i++) {
    dp[i] = new Array(y.length + 1)
  }

  for (let i = 0; i < x.length + 1; i++) {
    for (let j = 0; j < y.length + 1; j++) {
      if (i === 0) {
        dp[i][j] = j
      } else if (j === 0) {
        dp[i][j] = i
      } else {
        dp[i][j] = minimum(
          dp[i - 1][j - 1] +
            costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
          dp[i - 1][j] + 1,
          dp[i][j - 1] + 1
        )
      }
    }
  }

  return dp[x.length][y.length]
}

export { calculateLevenshteinDp }
