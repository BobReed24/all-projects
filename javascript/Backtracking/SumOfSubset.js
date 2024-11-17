const sumOfSubset = (set, subset, setindex, sum, targetSum) => {
  
  if (sum === targetSum) return [subset]

  if (sum > targetSum) return []

  let results = []

  set.slice(setindex).forEach((num, index) => {
    
    const nextSubset = [...subset, num]

    const nextSetIndex = setindex + index + 1

    const nextSum = sum + num

    const subsetResult = sumOfSubset(
      set,
      nextSubset,
      nextSetIndex,
      nextSum,
      targetSum
    )

    results = [...results, ...subsetResult]
  })

  return results
}

export { sumOfSubset }
