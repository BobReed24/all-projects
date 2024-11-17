package com.thealgorithms.datastructures.trees;

import java.util.ArrayList;
import java.util.List;

public class BSTRecursiveGeneric<T extends Comparable<T>> {

    private Node<T> root;

    public BSTRecursiveGeneric() {
        root = null;
    }

    public static void main(String[] args) {
        System.out.println("Testing for integer data...");
        
        BSTRecursiveGeneric<Integer> integerTree = new BSTRecursiveGeneric<Integer>();

        integerTree.add(5);
        integerTree.add(10);
        integerTree.add(9);
        assert !integerTree.find(4)
            : "4 is not yet present in BST";
        assert integerTree.find(10)
            : "10 should be present in BST";
        integerTree.remove(9);
        assert !integerTree.find(9)
            : "9 was just deleted from BST";
        integerTree.remove(1);
        assert !integerTree.find(1)
            : "Since 1 was not present so find deleting would do no change";
        integerTree.add(20);
        integerTree.add(70);
        assert integerTree.find(70)
            : "70 was inserted but not found";
        
        integerTree.inorder();
        System.out.println();
        System.out.println("Testing for string data...");
        
        BSTRecursiveGeneric<String> stringTree = new BSTRecursiveGeneric<String>();

        stringTree.add("banana");
        stringTree.add("pineapple");
        stringTree.add("date");
        assert !stringTree.find("girl")
            : "girl is not yet present in BST";
        assert stringTree.find("pineapple")
            : "10 should be present in BST";
        stringTree.remove("date");
        assert !stringTree.find("date")
            : "date was just deleted from BST";
        stringTree.remove("boy");
        assert !stringTree.find("boy")
            : "Since boy was not present so deleting would do no change";
        stringTree.add("india");
        stringTree.add("hills");
        assert stringTree.find("hills")
            : "hills was inserted but not found";
        
        stringTree.inorder();
    }

    private Node<T> delete(Node<T> node, T data) {
        if (node == null) {
            System.out.println("No such data present in BST.");
        } else if (node.data.compareTo(data) > 0) {
            node.left = delete(node.left, data);
        } else if (node.data.compareTo(data) < 0) {
            node.right = delete(node.right, data);
        } else {
            if (node.right == null && node.left == null) { 
                node = null;
            } else if (node.left == null) { 
                Node<T> temp = node.right;
                node.right = null;
                node = temp;
            } else if (node.right == null) { 
                Node<T> temp = node.left;
                node.left = null;
                node = temp;
            } else { 
                Node<T> temp = node.right;
                
                while (temp.left != null) {
                    temp = temp.left;
                }
                node.data = temp.data;
                node.right = delete(node.right, temp.data);
            }
        }
        return node;
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            node = new Node<>(data);
        } else if (node.data.compareTo(data) > 0) {
            node.left = insert(node.left, data);
        } else if (node.data.compareTo(data) < 0) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    private void preOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    private void postOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        System.out.print(node.data + " ");
    }

    private void inOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.print(node.data + " ");
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    private void inOrderSort(Node<T> node, List<T> sortedList) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inOrderSort(node.left, sortedList);
        }
        sortedList.add(node.data);
        if (node.right != null) {
            inOrderSort(node.right, sortedList);
        }
    }

    private boolean search(Node<T> node, T data) {
        if (node == null) {
            return false;
        } else if (node.data.compareTo(data) == 0) {
            return true;
        } else if (node.data.compareTo(data) > 0) {
            return search(node.left, data);
        } else {
            return search(node.right, data);
        }
    }

    public void add(T data) {
        this.root = insert(this.root, data);
    }

    public void remove(T data) {
        this.root = delete(this.root, data);
    }

    public void inorder() {
        System.out.println("Inorder traversal of this tree is:");
        inOrder(this.root);
        System.out.println(); 
    }

    public List<T> inorderSort() {
        List<T> sortedList = new ArrayList<>();
        inOrderSort(this.root, sortedList);
        return sortedList;
    }

    public void postorder() {
        System.out.println("Postorder traversal of this tree is:");
        postOrder(this.root);
        System.out.println(); 
    }

    public void preorder() {
        System.out.println("Preorder traversal of this tree is:");
        preOrder(this.root);
        System.out.println(); 
    }

    public boolean find(T data) {
        if (search(this.root, data)) {
            System.out.println(data + " is present in given BST.");
            return true;
        }
        System.out.println(data + " not found.");
        return false;
    }

    private static class Node<T> {

        T data;
        Node<T> left;
        Node<T> right;

        Node(T d) {
            data = d;
            left = null;
            right = null;
        }
    }
}
