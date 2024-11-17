require 'set'

class TopologicalSorter
  attr_reader :graph

  def initialize(graph)
    raise ArgumentError, "Topological sort is only applicable to directed graphs!" unless graph.directed
    @graph = graph
  end

  def topological_sort
    @sorted_nodes = []
    @seen = Set[]
    @visited = Set[]
    for node in graph.nodes
      dfs_visit(node)
    end
    @sorted_nodes
  end

  private
  def dfs_visit(node)
    return if @visited.include?(node)
    raise ArgumentError, "Cycle in graph detected on node 
    @seen.add(node)
    for neighbor in graph.neighbors(node)
      dfs_visit(neighbor)
    end
    @visited.add(node)
    @sorted_nodes.unshift(node)
  end
end
