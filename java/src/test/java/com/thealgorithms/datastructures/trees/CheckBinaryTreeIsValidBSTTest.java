package com.thealgorithms.datastructures.trees;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CheckBinaryTreeIsValidBSTTest {
    @Test
    public void testRootNull() {
        assertTrue(CheckBinaryTreeIsValidBST.isBST(null));
    }

    @Test
    public void testOneNode() {
        final BinaryTree.Node root = TreeTestUtils.createTree(new Integer[] {Integer.MIN_VALUE});
        assertTrue(CheckBinaryTreeIsValidBST.isBST(root));
    }

    @Test
    public void testBinaryTreeIsBST() {
        final BinaryTree.Node root = TreeTestUtils.createTree(new Integer[] {9, 7, 13, 3, 8, 10, 20});
        assertTrue(CheckBinaryTreeIsValidBST.isBST(root));
    }

    @Test
    public void testBinaryTreeWithDuplicatedNodesIsNotBST() {
        final BinaryTree.Node root = TreeTestUtils.createTree(new Integer[] {9, 7, 13, 3, 8, 10, 13});
        assertFalse(CheckBinaryTreeIsValidBST.isBST(root));
    }

    @Test
    public void testBinaryTreeIsNotBST() {
        final BinaryTree.Node root = TreeTestUtils.createTree(new Integer[] {9, 7, 13, 3, 8, 10, 12});
        assertFalse(CheckBinaryTreeIsValidBST.isBST(root));
    }
}
