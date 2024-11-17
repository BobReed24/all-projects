function BellmanFord(graph, V, E, src, dest) {
  
  const dis = Array(V).fill(Infinity)
  
  dis[src] = 0

  for (let i = 0; i < V - 1; i++) {
    for (let j = 0; j < E; j++) {
      if (dis[graph[j][0]] + graph[j][2] < dis[graph[j][1]]) {
        dis[graph[j][1]] = dis[graph[j][0]] + graph[j][2]
      }
    }
  }
  
  for (let i = 0; i < E; i++) {
    const x = graph[i][0]
    const y = graph[i][1]
    const weight = graph[i][2]
    if (dis[x] !== Infinity && dis[x] + weight < dis[y]) {
      return null
    }
  }
  for (let i = 0; i < V; i++) {
    if (i === dest) return dis[i]
  }
}

export { BellmanFord }
