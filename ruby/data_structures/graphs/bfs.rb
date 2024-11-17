require 'set'

class GraphBfsResult
  attr_reader :visited
  attr_reader :parents
  attr_reader :distances

  def initialize(visited, parents, distances)
    @visited = visited
    @parents = parents
    @distances = distances
  end
end

def bfs(graph, start_node, seen_node_consumer: method(:do_nothing_on_node), visited_node_consumer: method(:do_nothing_on_node))
  seen = Set[]
  visited = Set[]
  parents = { start_node => nil }
  distances = { start_node => 0 }

  seen.add(start_node)
  seen_node_consumer.call(start_node)
  q = Queue.new
  q.push(start_node)
  until q.empty?
    node = q.pop
    for neighbor in graph.neighbors(node)
      unless seen.include?(neighbor)
        seen.add(neighbor)
        distances[neighbor] = distances[node] + 1
        parents[neighbor] = node
        seen_node_consumer.call(neighbor)
        q.push(neighbor)
      end
    end
    visited.add(node)
    visited_node_consumer.call(node)
  end

  GraphBfsResult.new(visited, parents, distances)
end

private
def do_nothing_on_node(node)
end
