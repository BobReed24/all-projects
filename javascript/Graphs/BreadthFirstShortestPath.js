import Queue from '../Data-Structures/Queue/Queue'

export function breadthFirstShortestPath(graph, startNode, targetNode) {
  
  if (startNode === targetNode) {
    return [startNode]
  }

  const visited = new Set()

  const initialPath = [startNode]
  const queue = new Queue()
  queue.enqueue(initialPath)

  while (!queue.isEmpty()) {
    
    const path = queue.dequeue()
    const node = path[path.length - 1]

    if (!visited.has(node)) {
      
      visited.add(node)

      const neighbors = graph[node]

      for (let i = 0; i < neighbors.length; i++) {
        const newPath = path.concat([neighbors[i]])

        if (neighbors[i] === targetNode) {
          return newPath
        }

        queue.enqueue(newPath)
      }
    }
  }

  return []
}
