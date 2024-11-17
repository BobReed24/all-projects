package com.thealgorithms.datastructures.trees;

import com.thealgorithms.datastructures.trees.BinaryTree.Node;
import java.util.HashMap;
import java.util.Map;

public final class CreateBinaryTreeFromInorderPreorder {
    private CreateBinaryTreeFromInorderPreorder() {
    }
    public static Node createTree(final Integer[] preorder, final Integer[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return createTree(preorder, inorder, 0, 0, inorder.length);
    }

    public static Node createTreeOptimized(final Integer[] preorder, final Integer[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return createTreeOptimized(preorder, inorderMap, 0, 0, inorder.length);
    }

    private static Node createTree(final Integer[] preorder, final Integer[] inorder, final int preStart, final int inStart, final int size) {
        if (size == 0) {
            return null;
        }

        Node root = new Node(preorder[preStart]);
        int i = inStart;
        while (!preorder[preStart].equals(inorder[i])) {
            i++;
        }
        int leftNodesCount = i - inStart;
        int rightNodesCount = size - leftNodesCount - 1;
        root.left = createTree(preorder, inorder, preStart + 1, inStart, leftNodesCount);
        root.right = createTree(preorder, inorder, preStart + leftNodesCount + 1, i + 1, rightNodesCount);
        return root;
    }

    private static Node createTreeOptimized(final Integer[] preorder, final Map<Integer, Integer> inorderMap, final int preStart, final int inStart, final int size) {
        if (size == 0) {
            return null;
        }

        Node root = new Node(preorder[preStart]);
        int i = inorderMap.get(preorder[preStart]);
        int leftNodesCount = i - inStart;
        int rightNodesCount = size - leftNodesCount - 1;
        root.left = createTreeOptimized(preorder, inorderMap, preStart + 1, inStart, leftNodesCount);
        root.right = createTreeOptimized(preorder, inorderMap, preStart + leftNodesCount + 1, i + 1, rightNodesCount);
        return root;
    }
}
