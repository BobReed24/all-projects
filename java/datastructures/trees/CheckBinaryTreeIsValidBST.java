package com.thealgorithms.datastructures.trees;

public final class CheckBinaryTreeIsValidBST {
    private CheckBinaryTreeIsValidBST() {
    }
    public static boolean isBST(BinaryTree.Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTUtil(BinaryTree.Node node, int min, int max) {
        
        if (node == null) {
            return true;
        }

        if (node.data < min || node.data > max) {
            return false;
        }

        return (isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max));
    }
}
