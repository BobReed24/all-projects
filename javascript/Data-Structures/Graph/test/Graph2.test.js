import { Graph } from '../Graph2'

describe('Test Graph2', () => {
  const vertices = ['A', 'B', 'C', 'D', 'E', 'F']
  const graph = new Graph(vertices.length)

  vertices.forEach((vertice) => graph.addVertex(vertice))

  graph.addEdge('A', 'B')
  graph.addEdge('A', 'D')
  graph.addEdge('A', 'E')
  graph.addEdge('B', 'C')
  graph.addEdge('D', 'E')
  graph.addEdge('E', 'F')
  graph.addEdge('E', 'C')
  graph.addEdge('C', 'F')

  it('Check adjacency lists', () => {
    const mockFn = vi.fn()
    graph.printGraph(mockFn)

    expect(mockFn.mock.calls.length).toBe(vertices.length)

    const adjListArr = mockFn.mock.calls.map((v) => v[0])

    expect(adjListArr).toEqual([
      'A -> B D E ',
      'B -> A C ',
      'C -> B E F ',
      'D -> A E ',
      'E -> A D F C ',
      'F -> E C '
    ])
  })
})
