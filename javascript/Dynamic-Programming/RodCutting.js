export function rodCut(prices, n) {
  const memo = new Array(n + 1)
  memo[0] = 0

  for (let i = 1; i <= n; i++) {
    let maxVal = Number.MIN_VALUE
    for (let j = 0; j < i; j++) {
      maxVal = Math.max(maxVal, prices[j] + memo[i - j - 1])
    }
    memo[i] = maxVal
  }

  return memo[n]
}
