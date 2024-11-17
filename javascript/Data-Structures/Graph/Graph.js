class Graph {
  constructor() {
    this.adjacencyMap = {}
  }

  addVertex(vertex) {
    this.adjacencyMap[vertex] = []
  }

  containsVertex(vertex) {
    return typeof this.adjacencyMap[vertex] !== 'undefined'
  }

  addEdge(vertex1, vertex2) {
    if (this.containsVertex(vertex1) && this.containsVertex(vertex2)) {
      this.adjacencyMap[vertex1].push(vertex2)
      this.adjacencyMap[vertex2].push(vertex1)
    }
  }

  printGraph(output = (value) => console.log(value)) {
    const keys = Object.keys(this.adjacencyMap)
    for (const i of keys) {
      const values = this.adjacencyMap[i]
      let vertex = ''
      for (const j of values) {
        vertex += j + ' '
      }
      output(i + ' -> ' + vertex)
    }
  }

  bfs(source, output = (value) => console.log(value)) {
    const queue = [[source, 0]] 
    const visited = new Set()

    while (queue.length) {
      const [node, level] = queue.shift() 
      if (visited.has(node)) {
        
        continue
      }

      visited.add(node)
      output(`Visited node ${node} at level ${level}.`)
      for (const next of this.adjacencyMap[node]) {
        queue.push([next, level + 1]) 
      }
    }
  }

  dfs(source, visited = new Set(), output = (value) => console.log(value)) {
    if (visited.has(source)) {
      
      return
    }

    output(`Visited node ${source}`)
    visited.add(source)
    for (const neighbour of this.adjacencyMap[source]) {
      this.dfs(neighbour, visited, output)
    }
  }
}

const example = () => {
  const g = new Graph()
  g.addVertex(1)
  g.addVertex(2)
  g.addVertex(3)
  g.addVertex(4)
  g.addVertex(5)
  g.addEdge(1, 2)
  g.addEdge(1, 3)
  g.addEdge(2, 4)
  g.addEdge(2, 5)

  g.bfs(1)

  g.dfs(1)
}

export { Graph, example }
