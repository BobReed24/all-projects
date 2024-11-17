package com.thealgorithms.datastructures.lists;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateAndDetectLoopTest {

    private CreateAndDetectLoop.Node head;

    @BeforeEach
    void setUp() {
        
        head = new CreateAndDetectLoop.Node(1);
        CreateAndDetectLoop.Node second = new CreateAndDetectLoop.Node(2);
        CreateAndDetectLoop.Node third = new CreateAndDetectLoop.Node(3);
        CreateAndDetectLoop.Node fourth = new CreateAndDetectLoop.Node(4);
        CreateAndDetectLoop.Node fifth = new CreateAndDetectLoop.Node(5);
        CreateAndDetectLoop.Node sixth = new CreateAndDetectLoop.Node(6);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
    }

    @Test
    void testDetectLoopNoLoop() {
        
        assertFalse(CreateAndDetectLoop.detectLoop(head), "There should be no loop.");
    }

    @Test
    void testCreateAndDetectLoopLoopExists() {
        
        CreateAndDetectLoop.createLoop(head, 2, 5);

        assertTrue(CreateAndDetectLoop.detectLoop(head), "A loop should be detected.");
    }

    @Test
    void testCreateLoopInvalidPosition() {
        
        CreateAndDetectLoop.createLoop(head, 0, 0);

        assertFalse(CreateAndDetectLoop.detectLoop(head), "There should be no loop with invalid positions.");
    }

    @Test
    void testCreateLoopSelfLoop() {
        
        CreateAndDetectLoop.createLoop(head, 3, 3);

        assertTrue(CreateAndDetectLoop.detectLoop(head), "A self-loop should be detected.");
    }

    @Test
    void testCreateLoopNoChangeForNonExistentPositions() {
        
        CreateAndDetectLoop.createLoop(head, 10, 20);

        assertFalse(CreateAndDetectLoop.detectLoop(head), "No loop should be created if positions are out of bounds.");
    }

    @Test
    void testMultipleNodesWithNoLoop() {
        
        assertFalse(CreateAndDetectLoop.detectLoop(head), "No loop should be detected for a standard linear list.");
    }

    @Test
    void testHeadToTailLoop() {
        
        CreateAndDetectLoop.createLoop(head, 1, 6);

        assertTrue(CreateAndDetectLoop.detectLoop(head), "A head-to-tail loop should be detected.");
    }
}
