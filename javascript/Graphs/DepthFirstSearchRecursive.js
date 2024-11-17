class GraphUnweightedUndirected {
  
  constructor() {
    this.connections = {}
  }

  addNode(node) {
    
    this.connections[node] = new Set()
  }

  addEdge(node1, node2) {
    
    if (!(node1 in this.connections)) {
      this.addNode(node1)
    }
    if (!(node2 in this.connections)) {
      this.addNode(node2)
    }
    this.connections[node1].add(node2)
    this.connections[node2].add(node1)
  }

  DFSRecursive(node, value, visited = new Set()) {
    
    if (node === value) {
      return true
    }
    
    visited.add(node)
    
    for (const neighbour of this.connections[node]) {
      if (!visited.has(neighbour)) {
        if (this.DFSRecursive(neighbour, value, visited)) {
          return true
        }
      }
    }
    return false
  }
}

export { GraphUnweightedUndirected }

