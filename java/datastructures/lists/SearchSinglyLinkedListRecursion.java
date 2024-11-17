package com.thealgorithms.datastructures.lists;

public class SearchSinglyLinkedListRecursion extends SinglyLinkedList {

    private boolean searchRecursion(Node node, int key) {
        return (node != null && (node.value == key || searchRecursion(node.next, key)));
    }

    @Override
    public boolean search(int key) {
        return searchRecursion(getHead(), key);
    }
}
