package com.thealgorithms.datastructures.lists;

public class CountSinglyLinkedListRecursion extends SinglyLinkedList {

    private int countRecursion(Node head) {
        return head == null ? 0 : 1 + countRecursion(head.next);
    }

    @Override
    public int count() {
        return countRecursion(getHead());
    }
}
