package com.thealgorithms.datastructures.trees;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateBinaryTreeFromInorderPreorderTest {
    @Test
    public void testOnNullArraysShouldReturnNullTree() {
        
        BinaryTree.Node root = CreateBinaryTreeFromInorderPreorder.createTree(null, null);
        BinaryTree.Node rootOpt = CreateBinaryTreeFromInorderPreorder.createTreeOptimized(null, null);

        Assertions.assertNull(root);
        Assertions.assertNull(rootOpt);
    }

    @Test
    public void testOnEmptyArraysShouldCreateNullTree() {
        
        Integer[] preorder = {};
        Integer[] inorder = {};

        BinaryTree.Node root = CreateBinaryTreeFromInorderPreorder.createTree(preorder, inorder);
        BinaryTree.Node rootOpt = CreateBinaryTreeFromInorderPreorder.createTreeOptimized(preorder, inorder);

        Assertions.assertNull(root);
        Assertions.assertNull(rootOpt);
    }

    @Test
    public void testOnSingleNodeTreeShouldCreateCorrectTree() {
        
        Integer[] preorder = {1};
        Integer[] inorder = {1};

        BinaryTree.Node root = CreateBinaryTreeFromInorderPreorder.createTree(preorder, inorder);
        BinaryTree.Node rootOpt = CreateBinaryTreeFromInorderPreorder.createTreeOptimized(preorder, inorder);

        checkTree(preorder, inorder, root);
        checkTree(preorder, inorder, rootOpt);
    }

    @Test
    public void testOnRightSkewedTreeShouldCreateCorrectTree() {
        
        Integer[] preorder = {1, 2, 3, 4};
        Integer[] inorder = {1, 2, 3, 4};

        BinaryTree.Node root = CreateBinaryTreeFromInorderPreorder.createTree(preorder, inorder);
        BinaryTree.Node rootOpt = CreateBinaryTreeFromInorderPreorder.createTreeOptimized(preorder, inorder);

        checkTree(preorder, inorder, root);
        checkTree(preorder, inorder, rootOpt);
    }

    @Test
    public void testOnLeftSkewedTreeShouldCreateCorrectTree() {
        
        Integer[] preorder = {1, 2, 3, 4};
        Integer[] inorder = {4, 3, 2, 1};

        BinaryTree.Node root = CreateBinaryTreeFromInorderPreorder.createTree(preorder, inorder);
        BinaryTree.Node rootOpt = CreateBinaryTreeFromInorderPreorder.createTreeOptimized(preorder, inorder);

        checkTree(preorder, inorder, root);
        checkTree(preorder, inorder, rootOpt);
    }

    @Test
    public void testOnNormalTreeShouldCreateCorrectTree() {
        
        Integer[] preorder = {3, 9, 20, 15, 7};
        Integer[] inorder = {9, 3, 15, 20, 7};

        BinaryTree.Node root = CreateBinaryTreeFromInorderPreorder.createTree(preorder, inorder);
        BinaryTree.Node rootOpt = CreateBinaryTreeFromInorderPreorder.createTreeOptimized(preorder, inorder);

        checkTree(preorder, inorder, root);
        checkTree(preorder, inorder, rootOpt);
    }

    private static void checkTree(Integer[] preorder, Integer[] inorder, BinaryTree.Node root) {
        Assertions.assertNotNull(root);
        Assertions.assertEquals(PreOrderTraversal.iterativePreOrder(root), Arrays.asList(preorder));
        Assertions.assertEquals(InorderTraversal.iterativeInorder(root), Arrays.asList(inorder));
    }
}
