export const subsequence = (str, seq, low, output = []) => {
  if (low <= str.length && str.length !== 0) {
    output.push(seq)
  }
  for (let i = low; i < str.length; i++) {
    subsequence(str, seq + str[i], i + 1, output)
  }
  return output
}
