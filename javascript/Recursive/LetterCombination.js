const letterCombinations = (digits) => {
  const length = digits?.length
  const result = []
  if (!length) {
    return result
  }
  const digitMap = {
    2: 'abc',
    3: 'def',
    4: 'ghi',
    5: 'jkl',
    6: 'mno',
    7: 'pqrs',
    8: 'tuv',
    9: 'wxyz'
  }

  const combinations = (index, combination) => {
    let letter
    let letterIndex
    if (index >= length) {
      result.push(combination)
      return
    }
    const digit = digitMap[digits[index]]
    letterIndex = 0
    while ((letter = digit[letterIndex++])) {
      combinations(index + 1, combination + letter)
    }
  }
  combinations(0, '')
  return result
}

export { letterCombinations }
