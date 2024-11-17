class DisjointSetTreeNode {
  
  constructor(key) {
    this.key = key
    this.parent = this
    this.rank = 0
  }
}

class DisjointSetTree {
  
  constructor() {
    
    this.map = {}
  }

  makeSet(x) {
    
    this.map[x] = new DisjointSetTreeNode(x)
  }

  findSet(x) {
    
    if (this.map[x] !== this.map[x].parent) {
      this.map[x].parent = this.findSet(this.map[x].parent.key)
    }
    return this.map[x].parent
  }

  union(x, y) {
    
    this.link(this.findSet(x), this.findSet(y))
  }

  link(x, y) {
    
    if (x.rank > y.rank) {
      y.parent = x
    } else {
      x.parent = y
      if (x.rank === y.rank) {
        y.rank += 1
      }
    }
  }
}

class GraphWeightedUndirectedAdjacencyList {
  
  constructor() {
    this.connections = {}
    this.nodes = 0
  }

  addNode(node) {
    
    this.connections[node] = {}
    this.nodes += 1
  }

  addEdge(node1, node2, weight) {
    
    if (!(node1 in this.connections)) {
      this.addNode(node1)
    }
    if (!(node2 in this.connections)) {
      this.addNode(node2)
    }
    this.connections[node1][node2] = weight
    this.connections[node2][node1] = weight
  }

  KruskalMST() {
    
    const edges = []
    const seen = new Set()
    for (const start of Object.keys(this.connections)) {
      for (const end of Object.keys(this.connections[start])) {
        if (!seen.has(`${start} ${end}`)) {
          seen.add(`${end} ${start}`)
          edges.push([start, end, this.connections[start][end]])
        }
      }
    }
    edges.sort((a, b) => a[2] - b[2])
    
    const disjointSet = new DisjointSetTree()
    Object.keys(this.connections).forEach((node) => disjointSet.makeSet(node))
    
    const graph = new GraphWeightedUndirectedAdjacencyList()
    let numEdges = 0
    let index = 0
    while (numEdges < this.nodes - 1) {
      const [u, v, w] = edges[index]
      index += 1
      if (disjointSet.findSet(u) !== disjointSet.findSet(v)) {
        numEdges += 1
        graph.addEdge(u, v, w)
        disjointSet.union(u, v)
      }
    }
    return graph
  }
}

export { GraphWeightedUndirectedAdjacencyList }

