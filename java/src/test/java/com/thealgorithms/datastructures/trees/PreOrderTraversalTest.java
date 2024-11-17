package com.thealgorithms.datastructures.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PreOrderTraversalTest {
    @Test
    public void testNullRoot() {
        assertEquals(Collections.emptyList(), PreOrderTraversal.recursivePreOrder(null));
        assertEquals(Collections.emptyList(), PreOrderTraversal.iterativePreOrder(null));
    }

    @Test
    public void testRecursivePreOrder() {
        final BinaryTree.Node root = TreeTestUtils.createTree(new Integer[] {1, 2, 3, 4, 5, 6, 7});
        List<Integer> expected = List.of(1, 2, 4, 5, 3, 6, 7);

        assertEquals(expected, PreOrderTraversal.recursivePreOrder(root));
        assertEquals(expected, PreOrderTraversal.iterativePreOrder(root));
    }

    @Test
    public void testRecursivePreOrderNonBalanced() {
        final BinaryTree.Node root = TreeTestUtils.createTree(new Integer[] {5, null, 6, null, 7, null, 8});
        List<Integer> expected = List.of(5, 6, 7, 8);

        assertEquals(expected, PreOrderTraversal.recursivePreOrder(root));
        assertEquals(expected, PreOrderTraversal.iterativePreOrder(root));
    }
}
