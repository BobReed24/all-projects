package com.thealgorithms.datastructures.disjointsetunion;

public class Node<T> {

    public int rank;

    public Node<T> parent;

    public T data;

    public Node(final T data) {
        this.data = data;
        parent = this; 
    }
}
