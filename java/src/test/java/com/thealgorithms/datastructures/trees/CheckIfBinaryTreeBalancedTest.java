package com.thealgorithms.datastructures.trees;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CheckIfBinaryTreeBalancedTest {
    @Test
    public void testRootNull() {
        assertTrue(CheckIfBinaryTreeBalanced.isBalancedRecursive(null));
        assertTrue(CheckIfBinaryTreeBalanced.isBalancedIterative(null));
    }

    @Test
    public void testOneNode() {
        final BinaryTree.Node root = TreeTestUtils.createTree(new Integer[] {Integer.MIN_VALUE});
        assertTrue(CheckIfBinaryTreeBalanced.isBalancedRecursive(root));
        assertTrue(CheckIfBinaryTreeBalanced.isBalancedIterative(root));
    }

    @Test
    public void testBinaryTreeIsBalancedEqualSubtreeHeights() {
        final BinaryTree.Node root = TreeTestUtils.createTree(new Integer[] {9, 7, 13, 3, 8, 10, 20});
        assertTrue(CheckIfBinaryTreeBalanced.isBalancedRecursive(root));
        assertTrue(CheckIfBinaryTreeBalanced.isBalancedIterative(root));
    }

    @Test
    public void testBinaryTreeIsBalancedWithDifferentHeights() {
        final BinaryTree.Node root = TreeTestUtils.createTree(new Integer[] {9, 7, 13, 3, 8});
        assertTrue(CheckIfBinaryTreeBalanced.isBalancedRecursive(root));
        assertTrue(CheckIfBinaryTreeBalanced.isBalancedIterative(root));
    }

    @Test
    public void testBinaryTreeNotBalanced() {
        final BinaryTree.Node root = TreeTestUtils.createTree(new Integer[] {9, 7, null, 3, 8});
        assertFalse(CheckIfBinaryTreeBalanced.isBalancedRecursive(root));
        assertFalse(CheckIfBinaryTreeBalanced.isBalancedIterative(root));
    }

    @Test
    public void testBinaryTreeNotBalancedBecauseLeftTreeNotBalanced() {
        final BinaryTree.Node root = TreeTestUtils.createTree(new Integer[] {9, 7, 13, 3, 8, null, null, 11});
        assertFalse(CheckIfBinaryTreeBalanced.isBalancedRecursive(root));
        assertFalse(CheckIfBinaryTreeBalanced.isBalancedIterative(root));
    }
}
