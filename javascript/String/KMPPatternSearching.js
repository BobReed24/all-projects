const computeLPS = (pattern) => {
  const lps = Array(pattern.length)
  lps[0] = 0
  for (let i = 1; i < pattern.length; i++) {
    let matched = lps[i - 1]
    while (matched > 0 && pattern[i] !== pattern[matched]) {
      matched = lps[matched - 1]
    }
    if (pattern[i] === pattern[matched]) {
      matched++
    }
    lps[i] = matched
  }
  return lps
}

const KMPSearch = (text, pattern) => {
  if (!pattern || !text) {
    return [] 
  }

  const lps = computeLPS(pattern)
  const result = []

  let matched = 0
  for (let i = 0; i < text.length; i++) {
    while (matched > 0 && text[i] !== pattern[matched]) {
      matched = lps[matched - 1]
    }
    if (text[i] === pattern[matched]) {
      matched++
    }
    if (matched === pattern.length) {
      result.push(i - pattern.length + 1)
      matched = lps[matched - 1]
    }
  }

  return result
}

export { KMPSearch }
