package com.thealgorithms.datastructures.stacks;

public class NodeStack<Item> {

    private class Node {
        Item data;
        Node previous;

        Node(Item data) {
            this.data = data;
            this.previous = null;
        }
    }

    private Node head; 
    private int size; 

    public NodeStack() {
        head = null;
        size = 0;
    }

    public void push(Item item) {
        Node newNode = new Node(item);
        newNode.previous = head;
        head = newNode;
        size++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty stack.");
        }
        Item data = head.data;
        head = head.previous;
        size--;
        return data;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek from an empty stack.");
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}
