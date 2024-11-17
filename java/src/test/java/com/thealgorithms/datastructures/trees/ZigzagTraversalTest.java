package com.thealgorithms.datastructures.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ZigzagTraversalTest {
    @Test
    public void testRootNull() {
        assertEquals(Collections.emptyList(), ZigzagTraversal.traverse(null));
    }

    @Test
    public void testSingleNodeTree() {
        final BinaryTree.Node root = TreeTestUtils.createTree(new Integer[] {50});
        assertEquals(List.of(List.of(50)), ZigzagTraversal.traverse(root));
    }

    @Test
    public void testZigzagTraversalCompleteTree() {
        final BinaryTree.Node root = TreeTestUtils.createTree(new Integer[] {1, 2, 3, 4, 5, 6, 7});
        assertEquals(List.of(List.of(1), List.of(3, 2), List.of(4, 5, 6, 7)), ZigzagTraversal.traverse(root));
    }

    @Test
    public void testZigzagTraversalDifferentHeight() {
        final BinaryTree.Node root = TreeTestUtils.createTree(new Integer[] {1, 2, 3, 4, 5, 6, 7, null, null, 8, null, null, 9});
        assertEquals(List.of(List.of(1), List.of(3, 2), List.of(4, 5, 6, 7), List.of(9, 8)), ZigzagTraversal.traverse(root));
    }
}
