const checkAnagramRegex = (str1, str2) => {
  
  if (typeof str1 !== 'string' || typeof str2 !== 'string') {
    throw new TypeError('Both arguments should be strings.')
  }

  if (str1.length !== str2.length) {
    return false
  }

  return ![...str1].reduce(
    (str2Acc, cur) => str2Acc.replace(new RegExp(cur, 'i'), ''), 
    str2
  )
}

const checkAnagramMap = (str1, str2) => {
  
  if (typeof str1 !== 'string' || typeof str2 !== 'string') {
    throw new TypeError('Both arguments should be strings.')
  }

  if (str1.length !== str2.length) {
    return false
  }

  const str1List = Array.from(str1.toUpperCase()) 

  const str1Occurs = str1List.reduce(
    (map, char) => map.set(char, map.get(char) + 1 || 1),
    new Map()
  )

  for (const char of str2.toUpperCase()) {
    
    if (!str1Occurs.has(char)) {
      return false
    }

    let getCharCount = str1Occurs.get(char)
    str1Occurs.set(char, --getCharCount)

    getCharCount === 0 && str1Occurs.delete(char)
  }

  return true
}

export { checkAnagramRegex, checkAnagramMap }
