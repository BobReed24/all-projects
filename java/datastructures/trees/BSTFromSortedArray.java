package com.thealgorithms.datastructures.trees;

import com.thealgorithms.datastructures.trees.BinaryTree.Node;

public final class BSTFromSortedArray {
    private BSTFromSortedArray() {
    }
    public static Node createBST(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return createBST(array, 0, array.length - 1);
    }

    private static Node createBST(int[] array, int startIdx, int endIdx) {
        
        if (startIdx > endIdx) {
            return null;
        }
        int mid = startIdx + (endIdx - startIdx) / 2;

        Node root = new Node(array[mid]);
        root.left = createBST(array, startIdx, mid - 1);
        root.right = createBST(array, mid + 1, endIdx);
        return root;
    }
}
