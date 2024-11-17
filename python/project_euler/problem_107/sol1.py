from __future__ import annotations

import os
from collections.abc import Mapping

EdgeT = tuple[int, int]

class Graph:
    
    def __init__(self, vertices: set[int], edges: Mapping[EdgeT, int]) -> None:
        self.vertices: set[int] = vertices
        self.edges: dict[EdgeT, int] = {
            (min(edge), max(edge)): weight for edge, weight in edges.items()
        }

    def add_edge(self, edge: EdgeT, weight: int) -> None:
        
        self.vertices.add(edge[0])
        self.vertices.add(edge[1])
        self.edges[(min(edge), max(edge))] = weight

    def prims_algorithm(self) -> Graph:
        
        subgraph: Graph = Graph({min(self.vertices)}, {})
        min_edge: EdgeT
        min_weight: int
        edge: EdgeT
        weight: int

        while len(subgraph.vertices) < len(self.vertices):
            min_weight = max(self.edges.values()) + 1
            for edge, weight in self.edges.items():
                if (edge[0] in subgraph.vertices) ^ (
                    edge[1] in subgraph.vertices
                ) and weight < min_weight:
                    min_edge = edge
                    min_weight = weight

            subgraph.add_edge(min_edge, min_weight)

        return subgraph

def solution(filename: str = "p107_network.txt") -> int:
    
    script_dir: str = os.path.abspath(os.path.dirname(__file__))
    network_file: str = os.path.join(script_dir, filename)
    edges: dict[EdgeT, int] = {}
    data: list[str]
    edge1: int
    edge2: int

    with open(network_file) as f:
        data = f.read().strip().split("\n")

    adjaceny_matrix = [line.split(",") for line in data]

    for edge1 in range(1, len(adjaceny_matrix)):
        for edge2 in range(edge1):
            if adjaceny_matrix[edge1][edge2] != "-":
                edges[(edge2, edge1)] = int(adjaceny_matrix[edge1][edge2])

    graph: Graph = Graph(set(range(len(adjaceny_matrix))), edges)

    subgraph: Graph = graph.prims_algorithm()

    initial_total: int = sum(graph.edges.values())
    optimal_total: int = sum(subgraph.edges.values())

    return initial_total - optimal_total

if __name__ == "__main__":
    print(f"{solution() = }")
