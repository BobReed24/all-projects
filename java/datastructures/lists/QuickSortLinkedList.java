package com.thealgorithms.datastructures.lists;

public class QuickSortLinkedList {

    private final SinglyLinkedList list; 
    private Node head; 

    public QuickSortLinkedList(SinglyLinkedList list) {
        this.list = list;
        this.head = list.getHead();
    }

    public void sortList() {
        head = sortList(head);
        list.setHead(head);
    }

    private Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node pivot = head;
        head = head.next;
        pivot.next = null;

        Node lessHead = new Node();
        Node lessTail = lessHead;
        Node greaterHead = new Node();
        Node greaterTail = greaterHead;

        while (head != null) {
            if (head.value < pivot.value) {
                lessTail.next = head;
                lessTail = lessTail.next;
            } else {
                greaterTail.next = head;
                greaterTail = greaterTail.next;
            }
            head = head.next;
        }

        lessTail.next = null;
        greaterTail.next = null;

        Node sortedLess = sortList(lessHead.next);
        Node sortedGreater = sortList(greaterHead.next);

        if (sortedLess == null) {
            pivot.next = sortedGreater;
            return pivot;
        } else {
            Node current = sortedLess;
            while (current.next != null) {
                current = current.next;
            }
            current.next = pivot;
            pivot.next = sortedGreater;
            return sortedLess;
        }
    }
}
