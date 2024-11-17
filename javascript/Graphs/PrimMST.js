import { KeyPriorityQueue } from '../Data-Structures/Heap/KeyPriorityQueue'
class GraphWeightedUndirectedAdjacencyList {
  
  constructor() {
    this.connections = {}
  }

  addNode(node) {
    
    this.connections[node] = {}
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

  PrimMST(start) {
    
    const distance = {}
    const parent = {}
    const priorityQueue = new KeyPriorityQueue()
    
    for (const node in this.connections) {
      distance[node] = node === start.toString() ? 0 : Infinity
      parent[node] = null
      priorityQueue.push(node, distance[node])
    }
    
    while (!priorityQueue.isEmpty()) {
      const node = priorityQueue.pop()
      Object.keys(this.connections[node]).forEach((neighbour) => {
        if (
          priorityQueue.contains(neighbour) &&
          distance[node] + this.connections[node][neighbour] <
            distance[neighbour]
        ) {
          distance[neighbour] =
            distance[node] + this.connections[node][neighbour]
          parent[neighbour] = node
          priorityQueue.update(neighbour, distance[neighbour])
        }
      })
    }

    const graph = new GraphWeightedUndirectedAdjacencyList()
    Object.keys(parent).forEach((node) => {
      if (node && parent[node]) {
        graph.addEdge(node, parent[node], this.connections[node][parent[node]])
      }
    })
    return graph
  }
}

export { GraphWeightedUndirectedAdjacencyList }
