function generateGrayCodes(n) {
  if (n <= 0) {
    return [0]
  }

  const grayCodes = [0, 1]

  for (let i = 1; i < n; i++) {
    const highestBit = 1 << i
    for (let j = grayCodes.length - 1; j >= 0; j--) {
      grayCodes.push(highestBit | grayCodes[j])
    }
  }

  return grayCodes
}

export { generateGrayCodes }
