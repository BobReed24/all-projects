const percentageOfLetter = (str, letter) => {
  if (typeof str !== 'string' || typeof letter !== 'string') {
    throw new Error('Input data must be strings')
  }
  let letterCount = 0
  
  for (let i = 0; i < str.length; i++) {
    
    letterCount += str[i].toLowerCase() === letter.toLowerCase() ? 1 : 0
  }
  const percentage = Math.floor((100 * letterCount) / str.length)
  return percentage
}

export { percentageOfLetter }
