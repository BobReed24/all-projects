package com.thealgorithms.datastructures.trees;

import java.util.HashMap;
import java.util.Stack;

public final class CheckIfBinaryTreeBalanced {
    private CheckIfBinaryTreeBalanced() {
    }
    
    public static boolean isBalancedRecursive(BinaryTree.Node root) {
        if (root == null) {
            return true;
        }
        
        boolean[] isBalanced = new boolean[1];
        isBalanced[0] = true;

        isBalancedRecursive(root, 0, isBalanced);
        return isBalanced[0];
    }

    private static int isBalancedRecursive(BinaryTree.Node node, int depth, boolean[] isBalanced) {
        
        if (node == null || !isBalanced[0]) {
            return 0;
        }

        int leftHeight = isBalancedRecursive(node.left, depth + 1, isBalanced);
        int rightHeight = isBalancedRecursive(node.right, depth + 1, isBalanced);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced[0] = false;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isBalancedIterative(BinaryTree.Node root) {
        if (root == null) {
            return true;
        }

        boolean isBalanced = true;

        Stack<BinaryTree.Node> nodeStack = new Stack<>();

        BinaryTree.Node lastVisited = null;

        HashMap<BinaryTree.Node, Integer> subtreeHeights = new HashMap<>();

        BinaryTree.Node node = root;

        while (!(nodeStack.isEmpty() && node == null) && isBalanced) {
            
            if (node != null) {
                nodeStack.push(node);
                node = node.left;
                
            } else {
                
                node = nodeStack.peek();

                if (node.right == null || node.right == lastVisited) {
                    
                    int leftHeight = 0;
                    int rightHeight = 0;

                    if (node.left != null) {
                        leftHeight = subtreeHeights.get(node.left);
                    }

                    if (node.right != null) {
                        rightHeight = subtreeHeights.get(node.right);
                    }

                    if (Math.abs(rightHeight - leftHeight) > 1) {
                        isBalanced = false;
                    }

                    subtreeHeights.put(node, Math.max(rightHeight, leftHeight) + 1);

                    nodeStack.pop();
                    lastVisited = node;

                    node = null;
                    
                } else {
                    node = node.right;
                }
            }
        }

        return isBalanced;
    }
}
