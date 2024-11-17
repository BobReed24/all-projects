package com.thealgorithms.datastructures.trees;

import java.util.Random;

public class Treap {

    public static class TreapNode {
        
        public int value;
        private int priority;
        private int size;
        public TreapNode left;
        public TreapNode right;

        public TreapNode(int valueParam, int priorityParam) {
            value = valueParam;
            priority = priorityParam;
            size = 1;
            left = null;
            right = null;
        }

        private void updateSize() {
            size = 1;
            if (left != null) {
                size += left.size;
            }
            if (right != null) {
                size += right.size;
            }
        }
    }

    private TreapNode root;
    private Random random = new Random();

    public Treap() {
        root = null;
    }

    private TreapNode merge(TreapNode left, TreapNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.priority > right.priority) {
            left.right = merge(left.right, right);
            left.updateSize();
            return left;
        } else {
            right.left = merge(left, right.left);
            right.updateSize();
            return right;
        }
    }

    private TreapNode[] split(TreapNode node, int key) {
        if (node == null) {
            return new TreapNode[] {null, null};
        }

        TreapNode[] result;

        if (node.value <= key) {
            result = split(node.right, key);
            node.right = result[0];
            node.updateSize();
            result[0] = node;
        } else {
            result = split(node.left, key);
            node.left = result[1];
            node.updateSize();
            result[1] = node;
        }

        return result;
    }

    public TreapNode insert(int value) {
        if (root == null) {
            root = new TreapNode(value, random.nextInt());
            return root;
        }

        TreapNode[] splitted = split(root, value);

        TreapNode node = new TreapNode(value, random.nextInt());

        TreapNode tempMerged = merge(splitted[0], node);
        tempMerged.updateSize();

        TreapNode merged = merge(tempMerged, splitted[1]);
        merged.updateSize();

        root = merged;

        return root;
    }

    public TreapNode delete(int value) {
        root = deleteNode(root, value);
        return root;
    }

    private TreapNode deleteNode(TreapNode root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            root = merge(root.left, root.right);
        }

        if (root != null) {
            root.updateSize();
        }
        return root;
    }

    public void inOrder() {
        System.out.print("{");
        printInorder(root);
        System.out.print("}");
    }

    private void printInorder(TreapNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.value + ",");
        printInorder(root.right);
    }

    public void preOrder() {
        System.out.print("{");
        printPreOrder(root);
        System.out.print("}");
    }

    private void printPreOrder(TreapNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + ",");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public void postOrder() {
        System.out.print("{");
        printPostOrder(root);
        System.out.print("}");
    }

    private void printPostOrder(TreapNode root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.value + ",");
    }

    public TreapNode search(int value) {
        return searchVal(root, value);
    }

    private TreapNode searchVal(TreapNode root, int value) {
        if (root == null) {
            return null;
        }

        if (root.value == value) {
            return root;
        } else if (root.value < value) {
            return searchVal(root.right, value);
        } else {
            return searchVal(root.left, value);
        }
    }

    public TreapNode lowerBound(int value) {
        TreapNode lowerBoundNode = null;
        TreapNode current = root;

        while (current != null) {
            if (current.value >= value) {
                lowerBoundNode = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return lowerBoundNode;
    }

    public TreapNode upperBound(int value) {
        TreapNode upperBoundNode = null;
        TreapNode current = root;

        while (current != null) {
            if (current.value > value) {
                upperBoundNode = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return upperBoundNode;
    }

    public int size() {
        if (root == null) {
            return 0;
        }
        return root.size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public TreapNode getRoot() {
        return root;
    }

    public TreapNode getLeft(TreapNode node) {
        return node.left;
    }

    public TreapNode getRight(TreapNode node) {
        return node.right;
    }

    public String toString(TreapNode node) {
        return "{value : " + node.value + ", priority : " + node.priority + ", subTreeSize = " + node.size + ", left = " + node.left + ", right = " + node.right + "}";
    }
}
