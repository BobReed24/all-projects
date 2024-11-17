package com.thealgorithms.datastructures.lists;

public class ReverseKGroup {

    public int length(Node head) {
        Node curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }

    public Node reverse(Node head, int count, int k) {
        if (count < k) {
            return head;
        }
        Node prev = null;
        int count1 = 0;
        Node curr = head;
        Node next = null;
        while (curr != null && count1 < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count1++;
        }

        if (next != null) {
            head.next = reverse(next, count - k, k);
        }
        return prev;
    }

    public Node reverseKGroup(Node head, int k) {
        int count = length(head);
        return reverse(head, count, k);
    }
}
