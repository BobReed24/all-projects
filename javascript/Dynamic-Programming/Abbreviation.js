export const isAbbreviation = (source, target) => {
  const sourceLength = source.length
  const targetLength = target.length

  let canAbbreviate = Array.from({ length: sourceLength + 1 }, () =>
    Array(targetLength + 1).fill(false)
  )
  
  canAbbreviate[0][0] = true

  for (let sourceIndex = 0; sourceIndex < sourceLength; sourceIndex++) {
    for (let targetIndex = 0; targetIndex <= targetLength; targetIndex++) {
      if (canAbbreviate[sourceIndex][targetIndex]) {
        
        if (
          targetIndex < targetLength &&
          source[sourceIndex].toUpperCase() === target[targetIndex]
        ) {
          canAbbreviate[sourceIndex + 1][targetIndex + 1] = true
        }
        
        if (source[sourceIndex] === source[sourceIndex].toLowerCase()) {
          canAbbreviate[sourceIndex + 1][targetIndex] = true
        }
      }
    }
  }

  return canAbbreviate[sourceLength][targetLength]
}
