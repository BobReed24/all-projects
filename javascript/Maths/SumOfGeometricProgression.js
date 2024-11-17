function sumOfGeometricProgression(firstTerm, commonRatio, numOfTerms) {
  if (!Number.isFinite(numOfTerms)) {
    
    if (Math.abs(commonRatio) < 1) return firstTerm / (1 - commonRatio)
    throw new Error(
      'The geometric progression is diverging, and its sum cannot be calculated'
    )
  }

  if (commonRatio === 1) return firstTerm * numOfTerms

  return (
    (firstTerm * (Math.pow(commonRatio, numOfTerms) - 1)) / (commonRatio - 1)
  )
}

export { sumOfGeometricProgression }
