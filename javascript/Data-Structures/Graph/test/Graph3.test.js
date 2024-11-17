import { Graph } from '../Graph3'

describe('Test Graph3', () => {
  const g = new Graph()

  g.addVertex('A')
  g.addVertex('B')
  g.addVertex('C')
  g.addVertex('D')
  g.addVertex('E')
  g.addVertex('F')

  g.addEdge('A', 'B')
  g.addEdge('A', 'C')
  g.addEdge('B', 'D')
  g.addEdge('C', 'E')
  g.addEdge('D', 'E')
  g.addEdge('D', 'F')
  g.addEdge('E', 'F')

  it('Check iterative DFS List', () => {
    const iterativeDFSList = g.DFSIterative('A')
    expect(iterativeDFSList).toEqual(['A', 'C', 'E', 'F', 'D', 'B'])
  })

  it('Check recursive DFS List', () => {
    const recursiveDFSList = g.DFS('A')
    expect(recursiveDFSList).toEqual(['A', 'B', 'D', 'E', 'C', 'F'])
  })

  it('Check BFS List', () => {
    const BFSList = g.BFS('A')
    expect(BFSList).toEqual(['A', 'B', 'C', 'D', 'E', 'F'])
  })

  it('Check iterative DFS List After Removing Vertex B', () => {
    g.removeVertex('B')
    const iterativeDFSList = g.DFSIterative('A')
    expect(iterativeDFSList).toEqual(['A', 'C', 'E', 'F', 'D'])
  })

  it('Check recursive DFS List After Removing Vertex B', () => {
    g.removeVertex('B')
    const recursiveDFSList = g.DFS('A')
    expect(recursiveDFSList).toEqual(['A', 'C', 'E', 'D', 'F'])
  })

  it('Check BFS List After Removing Vertex B', () => {
    g.removeVertex('B')
    const BFSList = g.BFS('A')
    expect(BFSList).toEqual(['A', 'C', 'E', 'D', 'F'])
  })
})
