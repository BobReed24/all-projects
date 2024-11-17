package com.thealgorithms.datastructures.trees;

public class AVLSimple {

    private class Node {

        int data;
        int height;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    private Node root;

    public void insert(int data) {
        this.root = insert(this.root, data);
    }

    private Node insert(Node node, int item) {
        if (node == null) {
            return new Node(item);
        }
        if (node.data > item) {
            node.left = insert(node.left, item);
        }
        if (node.data < item) {
            node.right = insert(node.right, item);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int bf = bf(node);
        
        if (bf > 1 && item < node.left.data) {
            return rightRotate(node);
        }
        
        if (bf < -1 && item > node.right.data) {
            return leftRotate(node);
        }
        
        if (bf < -1 && item < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        if (bf > 1 && item > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        return node;
    }

    public void display() {
        this.display(this.root);
        System.out.println(this.root.height);
    }

    private void display(Node node) {
        String str = "";
        if (node.left != null) {
            str += node.left.data + "=>";
        } else {
            str += "END=>";
        }
        str += node.data + "";
        if (node.right != null) {
            str += "<=" + node.right.data;
        } else {
            str += "<=END";
        }
        System.out.println(str);
        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int bf(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private Node rightRotate(Node c) {
        Node b = c.left;
        Node t3 = b.right;

        b.right = c;
        c.left = t3;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;
        return b;
    }

    private Node leftRotate(Node c) {
        Node b = c.right;
        Node t3 = b.left;

        b.left = c;
        c.right = t3;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;
        return b;
    }
}
