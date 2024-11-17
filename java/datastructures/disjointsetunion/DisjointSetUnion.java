package com.thealgorithms.datastructures.disjointsetunion;

public class DisjointSetUnion<T> {

    public Node<T> makeSet(final T x) {
        return new Node<T>(x);
    }

    public Node<T> findSet(Node<T> node) {
        while (node != node.parent) {
            node = node.parent;
        }
        return node;
    }

    public void unionSets(final Node<T> x, final Node<T> y) {
        Node<T> nx = findSet(x);
        Node<T> ny = findSet(y);

        if (nx == ny) {
            return; 
        }
        
        if (nx.rank > ny.rank) {
            ny.parent = nx;
        } else if (ny.rank > nx.rank) {
            nx.parent = ny;
        } else {
            
            ny.parent = nx;
            nx.rank++;
        }
    }
}
