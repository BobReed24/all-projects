export const longestValidParentheses = (s) => {
  const n = s.length
  const stack = []

  const res = new Array(n).fill(-Infinity)

  for (let i = 0; i < n; i++) {
    const bracket = s[i]

    if (bracket === ')' && s[stack[stack.length - 1]] === '(') {
      res[i] = 1
      res[stack[stack.length - 1]] = 1
      stack.pop()
    } else {
      stack.push(i)
    }
  }

  for (let i = 1; i < n; i++) {
    res[i] = Math.max(res[i], res[i] + res[i - 1])
  }

  res.push(0)
  return Math.max(...res)
}
