class Graph {
  
  constructor(noOfVertices) {
    this.noOfVertices = noOfVertices
    this.AdjList = new Map()
  }

  addVertex(v) {
    
    this.AdjList.set(v, [])
  }

  addEdge(v, w) {
    
    this.AdjList.get(v).push(w)

    this.AdjList.get(w).push(v)
  }

  printGraph(output = (value) => console.log(value)) {
    
    const getKeys = this.AdjList.keys()

    for (const i of getKeys) {
      
      const getValues = this.AdjList.get(i)
      let conc = ''

      for (const j of getValues) {
        conc += j + ' '
      }

      output(i + ' -> ' + conc)
    }
  }
}

export { Graph }
