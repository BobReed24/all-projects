import { GraphWeightedUndirectedAdjacencyList } from '../PrimMST.js'

test('Test Case PrimMST 1', () => {
  
  const graph = new GraphWeightedUndirectedAdjacencyList()
  graph.addEdge(1, 2, 1)
  graph.addEdge(2, 3, 2)
  graph.addEdge(3, 4, 1)
  graph.addEdge(3, 5, 100) 
  graph.addEdge(4, 5, 5)
  
  const expectedGraph = new GraphWeightedUndirectedAdjacencyList()
  expectedGraph.addEdge(1, 2, 1)
  expectedGraph.addEdge(2, 3, 2)
  expectedGraph.addEdge(3, 4, 1)
  expectedGraph.addEdge(4, 5, 5)
  
  const res = graph.PrimMST(1)
  expect(res).toEqual(expectedGraph)
})
