package com.thealgorithms.devutils.nodes;

public class SimpleNode<E> extends Node<E> {

    private SimpleNode<E> nextNode;

    public SimpleNode() {
        super();
    }

    public SimpleNode(E data) {
        super(data);
    }

    public SimpleNode(E data, SimpleNode<E> nextNode) {
        super(data);
        this.nextNode = nextNode;
    }

    public boolean hasNext() {
        return (nextNode != null);
    }

    public SimpleNode<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(SimpleNode<E> nextNode) {
        this.nextNode = nextNode;
    }
}
