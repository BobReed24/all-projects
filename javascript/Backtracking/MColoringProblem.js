function mColoring(graph, m) {
  const colors = new Array(graph.length).fill(0)

  function isSafe(vertex, color) {
    for (let i = 0; i < graph.length; i++) {
      if (graph[vertex][i] && colors[i] === color) {
        return false
      }
    }
    return true
  }

  function solveColoring(vertex = 0) {
    if (vertex === graph.length) {
      return true
    }

    for (let color = 1; color <= m; color++) {
      if (isSafe(vertex, color)) {
        colors[vertex] = color

        if (solveColoring(vertex + 1)) {
          return true
        }

        colors[vertex] = 0
      }
    }
    return false
  }

  if (solveColoring()) {
    return colors
  }
  return null
}

export { mColoring }
