class GraphUnweightedUndirectedAdjacencyList {
  
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

  DFSComponent(components, node, visited) {
    
    components.push(node)
    const stack = [node]
    
    while (stack.length > 0) {
      const curr = stack.pop()
      visited.add(curr.toString())
      for (const neighbour of this.connections[curr].keys()) {
        if (!visited.has(neighbour.toString())) {
          stack.push(neighbour)
        }
      }
    }
  }

  connectedComponents() {
    
    const visited = new Set()
    const components = []
    for (const node of Object.keys(this.connections)) {
      if (!visited.has(node.toString())) {
        this.DFSComponent(components, node, visited)
      }
    }
    return components
  }
}

export { GraphUnweightedUndirectedAdjacencyList }

