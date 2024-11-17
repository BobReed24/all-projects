export class BinaryLifting {
  constructor(root, tree) {
    this.root = root
    this.connections = new Map()
    this.up = new Map() 
    for (const [i, j] of tree) {
      this.addEdge(i, j)
    }
    this.log = Math.ceil(Math.log2(this.connections.size))
    this.dfs(root, root)
  }

  addNode(node) {
    
    this.connections.set(node, new Set())
  }

  addEdge(node1, node2) {
    
    if (!this.connections.has(node1)) {
      this.addNode(node1)
    }
    if (!this.connections.has(node2)) {
      this.addNode(node2)
    }
    this.connections.get(node1).add(node2)
    this.connections.get(node2).add(node1)
  }

  dfs(node, parent) {
    
    this.up.set(node, new Map())
    this.up.get(node).set(0, parent)
    for (let i = 1; i < this.log; i++) {
      this.up
        .get(node)
        .set(i, this.up.get(this.up.get(node).get(i - 1)).get(i - 1))
    }
    for (const child of this.connections.get(node)) {
      if (child !== parent) this.dfs(child, node)
    }
  }

  kthAncestor(node, k) {
    
    if (k >= this.connections.size) {
      return this.root
    }
    
    for (let i = 0; i < this.log; i++) {
      if (k & (1 << i)) {
        node = this.up.get(node).get(i)
      }
    }
    return node
  }
}

function binaryLifting(root, tree, queries) {
  const graphObject = new BinaryLifting(root, tree)
  const ancestors = []
  for (const [node, k] of queries) {
    const ancestor = graphObject.kthAncestor(node, k)
    ancestors.push(ancestor)
  }
  return ancestors
}

export default binaryLifting
