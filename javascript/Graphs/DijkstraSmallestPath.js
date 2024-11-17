function solve(graph, s) {
  const solutions = {}
  solutions[s] = []
  solutions[s].dist = 0

  while (true) {
    let p = null
    let neighbor = null
    let dist = Infinity

    for (const n in solutions) {
      if (!solutions[n]) {
        continue
      }
      const ndist = solutions[n].dist
      const adj = graph[n]

      for (const a in adj) {
        if (solutions[a]) {
          continue
        }

        const d = adj[a] + ndist
        if (d < dist) {
          p = solutions[n]
          neighbor = a
          dist = d
        }
      }
    }

    if (dist === Infinity) {
      break
    }

    solutions[neighbor] = p.concat(neighbor)
    
    solutions[neighbor].dist = dist
  }

  return solutions
}

export { solve }
