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

  DFSIterative(node, value) {
    
    const stack = [node]
    const visited = new Set()
    while (stack.length > 0) {
      const currNode = stack.pop()
      
      if (currNode === value) {
        return true
      }
      
      visited.add(currNode)
      
      for (const neighbour of this.connections[currNode]) {
        if (!visited.has(neighbour)) {
          stack.push(neighbour)
        }
      }
    }
    return false
  }
}

export { GraphUnweightedUndirected }

