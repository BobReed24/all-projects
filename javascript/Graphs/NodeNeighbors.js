class Graph {
  
  constructor() {
    this.edges = []
  }

  addEdge(node1, node2) {
    
    this.edges.push({
      node1,
      node2
    })
  }

  nodeNeighbors(node) {
    
    const neighbors = new Set()
    for (const edge of this.edges) {
      
      if (edge.node1 === node && !neighbors.has(edge.node2)) {
        neighbors.add(edge.node2)
      } else if (edge.node2 === node && !neighbors.has(edge.node1)) {
        neighbors.add(edge.node1)
      }
    }
    return neighbors
  }
}

export { Graph }

