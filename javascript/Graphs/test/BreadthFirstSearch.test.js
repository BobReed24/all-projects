import { breadthFirstSearch } from '../BreadthFirstSearch'

describe('BreadthFirstSearch', () => {
  const graph = {
    A: ['B', 'D'],
    B: ['E'],
    C: ['D'],
    D: ['A'],
    E: ['D'],
    F: ['G'],
    G: []
  }
  
  it('should return the visited nodes', () => {
    expect(Array.from(breadthFirstSearch(graph, 'C'))).toEqual([
      'C',
      'D',
      'A',
      'B',
      'E'
    ])
    expect(Array.from(breadthFirstSearch(graph, 'A'))).toEqual([
      'A',
      'B',
      'D',
      'E'
    ])
    expect(Array.from(breadthFirstSearch(graph, 'F'))).toEqual(['F', 'G'])
  })
})
