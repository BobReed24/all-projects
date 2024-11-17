package com.thealgorithms.datastructures.trees;

import com.thealgorithms.datastructures.trees.BinaryTree.Node;

public final class CheckTreeIsSymmetric {
    private CheckTreeIsSymmetric() {
    }

    public static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(Node leftSubtreeRoot, Node rightSubtreeRoot) {
        if (leftSubtreeRoot == null && rightSubtreeRoot == null) {
            return true;
        }

        if (isInvalidSubtree(leftSubtreeRoot, rightSubtreeRoot)) {
            return false;
        }

        return isSymmetric(leftSubtreeRoot.right, rightSubtreeRoot.left) && isSymmetric(leftSubtreeRoot.left, rightSubtreeRoot.right);
    }

    private static boolean isInvalidSubtree(Node leftSubtreeRoot, Node rightSubtreeRoot) {
        return leftSubtreeRoot == null || rightSubtreeRoot == null || leftSubtreeRoot.data != rightSubtreeRoot.data;
    }
}
