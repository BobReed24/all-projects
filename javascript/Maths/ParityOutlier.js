const parityOutlier = (integers) => {
  let oddsCount = 0 
  let evensCount = 0 
  let odd, even

  for (const e of integers) {
    if (!Number.isInteger(e)) {
      
      return null
    }
    if (e % 2 === 0) {
      
      even = e
      evensCount++
    } else {
      
      odd = e
      oddsCount++
    }
  }

  if (oddsCount === 0 || evensCount === 0) return null 
  if (oddsCount > 1 && evensCount > 1) return null 

  return oddsCount === 1 ? odd : even
}

export { parityOutlier }
