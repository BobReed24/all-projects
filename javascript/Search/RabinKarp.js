const BASE = 256 
const MOD = 997 

function rabinKarpSearch(text, pattern) {
  const patternLength = pattern.length
  const textLength = text.length
  const hashPattern = hash(pattern, patternLength)
  const hashText = []
  const indices = []

  hashText[0] = hash(text, patternLength)

  const basePow = Math.pow(BASE, patternLength - 1) % MOD

  for (let i = 1; i <= textLength - patternLength + 1; i++) {
    
    hashText[i] =
      (BASE * (hashText[i - 1] - text.charCodeAt(i - 1) * basePow) +
        text.charCodeAt(i + patternLength - 1)) %
      MOD

    if (hashText[i] < 0) {
      hashText[i] += MOD
    }

    if (hashText[i] === hashPattern) {
      if (text.substring(i, i + patternLength) === pattern) {
        indices.push(i) 
      }
    }
  }

  return indices
}

function hash(str, length) {
  let hashValue = 0
  for (let i = 0; i < length; i++) {
    hashValue = (hashValue * BASE + str.charCodeAt(i)) % MOD
  }
  return hashValue
}

export { rabinKarpSearch }
