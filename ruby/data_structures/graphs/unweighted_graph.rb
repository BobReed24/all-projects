require 'set'

class UnweightedGraph
  attr_reader :nodes
  attr_reader :directed

  def initialize(nodes: [], neighbors: {}, directed: true)
    @nodes = Set[]
    @neighbors = {}
    @directed = directed
    for node in nodes
      add_node(node)
    end
    neighbors.each do |node, neighbors|
      for neighbor in neighbors
        add_edge(node, neighbor)
      end
    end
  end

  def add_node(node)
    if include?(node)
      raise ArgumentError, "node 
    end
    @nodes.add(node)
    @neighbors[node] = Set[]
  end

  def add_edge(start_node, end_node)
    if has_neighbor?(start_node, end_node)
      raise ArgumentError, "node 
    end
    @neighbors[start_node].add(end_node)
    @neighbors[end_node].add(start_node) unless directed
  end

  def neighbors(node)
    unless include?(node)
      raise ArgumentError, "node 
    end
    @neighbors[node]
  end

  def empty?
    nodes.empty?
  end

  def include?(node)
    nodes.include?(node)
  end

  def has_neighbor?(start_node, end_node)
    neighbors(start_node).include?(end_node)
  end
end
