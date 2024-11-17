package com.thealgorithms.datastructures.lists;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {

    private SinglyLinkedList createSampleList(int length) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            Node node = new Node(i);
            nodeList.add(node);
        }

        for (int i = 0; i < length - 1; i++) {
            nodeList.get(i).next = nodeList.get(i + 1);
        }

        return new SinglyLinkedList(nodeList.get(0), length);
    }

    @Test
    void detectLoop() {
        
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);

        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = firstNode;

        SinglyLinkedList listHasLoop = new SinglyLinkedList(firstNode, 4);
        assertTrue(listHasLoop.detectLoop());

        SinglyLinkedList listHasNoLoop = createSampleList(5);
        assertFalse(listHasNoLoop.detectLoop());
    }

    @Test
    void middle() {
        int oddNumberOfNode = 7;
        SinglyLinkedList list = createSampleList(oddNumberOfNode);
        assertEquals(oddNumberOfNode / 2 + 1, list.middle().value);
        int evenNumberOfNode = 8;
        list = createSampleList(evenNumberOfNode);
        assertEquals(evenNumberOfNode / 2, list.middle().value);

        list = new SinglyLinkedList();
        assertNull(list.middle());

        list = createSampleList(1);
        assertEquals(list.getHead(), list.middle());
    }

    @Test
    void swap() {
        SinglyLinkedList list = createSampleList(5);
        assertEquals(1, list.getHead().value);
        assertEquals(5, list.getNth(4));
        list.swapNodes(1, 5);
        assertEquals(5, list.getHead().value);
        assertEquals(1, list.getNth(4));
    }

    @Test
    void clear() {
        SinglyLinkedList list = createSampleList(5);
        assertEquals(5, list.size());
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void search() {
        SinglyLinkedList list = createSampleList(10);
        assertTrue(list.search(5));
        assertFalse(list.search(20));
    }

    @Test
    void deleteNth() {
        SinglyLinkedList list = createSampleList(10);
        assertTrue(list.search(7));
        list.deleteNth(6); 
        assertFalse(list.search(7));
    }
    
    @Test
    void reverseList() {

        SinglyLinkedList list = createSampleList(4);

        Node head = list.reverseListIter(list.getHead());

        Node firstNode = head; 
        Node secondNode = firstNode.next; 
        Node thirdNode = secondNode.next; 
        Node fourthNode = thirdNode.next; 

        assertEquals(1, fourthNode.value);
        assertEquals(2, thirdNode.value);
        assertEquals(3, secondNode.value);
        assertEquals(4, firstNode.value);
    }

    @Test
    void reverseListNullPointer() {
        
        SinglyLinkedList list = new SinglyLinkedList();
        Node first = list.getHead();

        Node head = list.reverseListIter(first);

        assertEquals(head, first);
    }

    @Test
    void reverseListTest() {
        
        SinglyLinkedList list = createSampleList(20);

        Node head = list.reverseListIter(list.getHead());

        Node temp = head;

        int i = 20; 
        
        while (temp != null && i > 0) {
            assertEquals(i, temp.value);
            temp = temp.next;
            i--;
        }
    }
    
    void recursiveReverseList() {
        
        SinglyLinkedList list = createSampleList(5);

        Node head = list.reverseListRec(list.getHead());

        assertEquals(5, head.value);
        assertEquals(4, head.next.value);
        assertEquals(3, head.next.next.value);
        assertEquals(2, head.next.next.next.value);
        assertEquals(1, head.next.next.next.next.value);
    }

    @Test
    void recursiveReverseListNullPointer() {
        
        SinglyLinkedList list = new SinglyLinkedList();
        Node first = list.getHead();

        Node head = list.reverseListRec(first);

        assertNull(head);
    }

    @Test
    void recursiveReverseListTest() {
        
        SinglyLinkedList list = createSampleList(20);

        Node head = list.reverseListRec(list.getHead());

        int i = 20;
        Node temp = head;
        while (temp != null && i > 0) {
            assertEquals(i, temp.value);
            temp = temp.next;
            i--;
        }
    }

    @Test
    void readWithEnhancedForLoopTest() {
        final var expeced = new ArrayList<Integer>(Arrays.asList(10, 20, 30));

        SinglyLinkedList list = new SinglyLinkedList();
        for (final var x : expeced) {
            list.insert(x);
        }

        var readElements = new ArrayList<Integer>();
        for (final var x : list) {
            readElements.add(x);
        }

        assertEquals(readElements, expeced);
    }

    @Test
    void toStringTest() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        assertEquals("1->2->3", list.toString());
    }

    @Test
    void toStringForEmptyListTest() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertEquals("", list.toString());
    }

    @Test
    void countTest() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(10);
        list.insert(20);
        assertEquals(2, list.count());
    }

    @Test
    void countForEmptyListTest() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertEquals(0, list.count());
    }
}
