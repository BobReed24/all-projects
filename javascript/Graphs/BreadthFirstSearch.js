import Queue from '../Data-Structures/Queue/Queue'

export function breadthFirstSearch(graph, startingNode) {
  
  const visited = new Set()

  const queue = new Queue()
  queue.enqueue(startingNode)

  while (!queue.isEmpty()) {
    
    const node = queue.dequeue()

    if (!visited.has(node)) {
      
      visited.add(node)
      const neighbors = graph[node]

      for (let i = 0; i < neighbors.length; i++) {
        queue.enqueue(neighbors[i])
      }
    }
  }

  return visited
}
