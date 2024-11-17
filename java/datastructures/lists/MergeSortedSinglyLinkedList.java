package com.thealgorithms.datastructures.lists;

public class MergeSortedSinglyLinkedList extends SinglyLinkedList {

    public static SinglyLinkedList merge(SinglyLinkedList listA, SinglyLinkedList listB) {
        if (listA == null || listB == null) {
            throw new NullPointerException("Input lists must not be null.");
        }

        Node headA = listA.getHead();
        Node headB = listB.getHead();
        int size = listA.size() + listB.size();

        Node head = new Node();
        Node tail = head;
        while (headA != null && headB != null) {
            if (headA.value <= headB.value) {
                tail.next = headA;
                headA = headA.next;
            } else {
                tail.next = headB;
                headB = headB.next;
            }
            tail = tail.next;
        }

        tail.next = (headA == null) ? headB : headA;

        return new SinglyLinkedList(head.next, size);
    }
}
