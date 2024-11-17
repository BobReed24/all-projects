function jugglerSequence(n) {
  const sequence = []
  sequence.push(n)
  
  while (n !== 1) {
    n = Math.floor(n ** ((n % 2) + 0.5))
    sequence.push(n)
  }
  return sequence
}

export { jugglerSequence }
