package com.thealgorithms.datastructures.lists;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class RotateSinglyLinkedListsTest {

    private final RotateSinglyLinkedLists rotator = new RotateSinglyLinkedLists();

    private Node createLinkedList(int[] values) {
        if (values.length == 0) {
            return null;
        }

        Node head = new Node(values[0]);
        Node current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }
        return head;
    }

    private String linkedListToString(Node head) {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }

    @Test
    public void testRotateRightEmptyList() {
        
        assertNull(rotator.rotateRight(null, 2));
    }

    @Test
    public void testRotateRightSingleNodeList() {
        
        Node singleNode = new Node(5);
        Node rotatedSingleNode = rotator.rotateRight(singleNode, 3);
        assertEquals("5", linkedListToString(rotatedSingleNode));
    }

    @Test
    public void testRotateRightMultipleElementsList() {
        
        Node head = createLinkedList(new int[] {1, 2, 3, 4, 5});
        Node rotated = rotator.rotateRight(head, 2);
        assertEquals("4 -> 5 -> 1 -> 2 -> 3", linkedListToString(rotated));
    }

    @Test
    public void testRotateRightFullRotation() {
        
        Node head = createLinkedList(new int[] {1, 2, 3, 4, 5});
        Node rotated = rotator.rotateRight(head, 7);
        assertEquals("4 -> 5 -> 1 -> 2 -> 3", linkedListToString(rotated));
    }

    @Test
    public void testRotateRightZeroRotation() {
        
        Node head = createLinkedList(new int[] {1, 2, 3, 4, 5});
        Node rotated = rotator.rotateRight(head, 0);
        assertEquals("1 -> 2 -> 3 -> 4 -> 5", linkedListToString(rotated));
    }

    @Test
    public void testRotateRightByListLength() {
        
        Node head = createLinkedList(new int[] {1, 2, 3, 4, 5});
        Node rotated = rotator.rotateRight(head, 5);
        assertEquals("1 -> 2 -> 3 -> 4 -> 5", linkedListToString(rotated));
    }

    @Test
    public void testRotateRightByMultipleOfListLength() {
        Node head = createLinkedList(new int[] {1, 2, 3, 4, 5});
        Node rotated = rotator.rotateRight(head, 10); 
        assertEquals("1 -> 2 -> 3 -> 4 -> 5", linkedListToString(rotated));
    }

    @Test
    public void testRotateRightLongerList() {
        
        Node head = createLinkedList(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        Node rotated = rotator.rotateRight(head, 4);
        assertEquals("6 -> 7 -> 8 -> 9 -> 1 -> 2 -> 3 -> 4 -> 5", linkedListToString(rotated));
    }
}
