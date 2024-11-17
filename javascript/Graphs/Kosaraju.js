class Kosaraju {
  constructor(graph) {
    this.connections = {}
    this.reverseConnections = {}
    this.stronglyConnectedComponents = []
    for (const [i, j] of graph) {
      this.addEdge(i, j)
    }
    this.topoSort()
    return this.kosaraju()
  }

  addNode(node) {
    
    this.connections[node] = new Set()
    this.reverseConnections[node] = new Set()
    this.topoSorted = []
  }

  addEdge(node1, node2) {
    
    if (!(node1 in this.connections) || !(node1 in this.reverseConnections)) {
      this.addNode(node1)
    }
    if (!(node2 in this.connections) || !(node2 in this.reverseConnections)) {
      this.addNode(node2)
    }
    this.connections[node1].add(node2)
    this.reverseConnections[node2].add(node1)
  }

  dfsTopoSort(node, visited) {
    visited.add(node)
    for (const child of this.connections[node]) {
      if (!visited.has(child)) this.dfsTopoSort(child, visited)
    }
    this.topoSorted.push(node)
  }

  topoSort() {
    
    const visited = new Set()
    const nodes = Object.keys(this.connections).map((key) => Number(key))
    for (const node of nodes) {
      if (!visited.has(node)) this.dfsTopoSort(node, visited)
    }
  }

  dfsKosaraju(node, visited) {
    visited.add(node)
    this.stronglyConnectedComponents[
      this.stronglyConnectedComponents.length - 1
    ].push(node)
    for (const child of this.reverseConnections[node]) {
      if (!visited.has(child)) this.dfsKosaraju(child, visited)
    }
  }

  kosaraju() {
    
    const visited = new Set()
    while (this.topoSorted.length > 0) {
      const node = this.topoSorted.pop()
      if (!visited.has(node)) {
        this.stronglyConnectedComponents.push([])
        this.dfsKosaraju(node, visited)
      }
    }
    return this.stronglyConnectedComponents
  }
}

function kosaraju(graph) {
  const stronglyConnectedComponents = new Kosaraju(graph)
  return stronglyConnectedComponents
}

export { kosaraju }

