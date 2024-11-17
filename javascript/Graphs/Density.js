function density(numberOfNodes, numberOfEdges, isDirected = false) {
  const multi = isDirected ? 1 : 2
  return (multi * numberOfEdges) / (numberOfNodes * (numberOfNodes - 1))
}

export { density }
