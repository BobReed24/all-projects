package com.thealgorithms.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    static class Node {

        public int data;
        
        public Node left;
        
        public Node right;
        
        public Node parent;

        Node(int value) {
            data = value;
            left = null;
            right = null;
            parent = null;
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (key < current.data) {
                if (current.left == null) {
                    return current; 
                }
                current = current.left;
            } else if (key > current.data) {
                if (current.right == null) {
                    return current;
                }
                current = current.right;
            } else { 
                return current;
            }
        }
        return null;
    }

    public void put(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            
            Node parent = find(value);

            if (value < parent.data) {
                parent.left = newNode;
                parent.left.parent = parent;
            } else {
                parent.right = newNode;
                parent.right.parent = parent;
            }
        }
    }

    public boolean remove(int value) {
        
        Node temp = find(value);

        if (temp.data != value) {
            return false;
        }

        if (temp.right == null && temp.left == null) {
            if (temp == root) {
                root = null;
            } 
            
            else if (temp.parent.data < temp.data) {
                temp.parent.right = null;
            } else {
                temp.parent.left = null;
            }
            return true;
        } 
        else if (temp.left != null && temp.right != null) {
            Node successor = findSuccessor(temp);

            successor.left = temp.left;
            successor.left.parent = successor;

            if (successor.parent != temp) {
                if (successor.right != null) {
                    successor.right.parent = successor.parent;
                    successor.parent.left = successor.right;
                } else {
                    successor.parent.left = null;
                }
                successor.right = temp.right;
                successor.right.parent = successor;
            }

            if (temp == root) {
                successor.parent = null;
                root = successor;
            } 
            else {
                successor.parent = temp.parent;

                if (temp.parent.data < temp.data) {
                    temp.parent.right = successor;
                } else {
                    temp.parent.left = successor;
                }
            }
            return true;
        } 
        else {
            
            if (temp.right != null) {
                if (temp == root) {
                    root = temp.right;
                    return true;
                }

                temp.right.parent = temp.parent;

                if (temp.data < temp.parent.data) {
                    temp.parent.left = temp.right;
                } else {
                    temp.parent.right = temp.right;
                }
            } 
            else {
                if (temp == root) {
                    root = temp.left;
                    return true;
                }

                temp.left.parent = temp.parent;

                if (temp.data < temp.parent.data) {
                    temp.parent.left = temp.left;
                } else {
                    temp.parent.right = temp.left;
                }
            }
            return true;
        }
    }

    public Node findSuccessor(Node n) {
        if (n.right == null) {
            return n;
        }
        Node current = n.right;
        Node parent = n.right;
        while (current != null) {
            parent = current;
            current = current.left;
        }
        return parent;
    }

    public Node getRoot() {
        return root;
    }

    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.right);
        }
    }

    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.data + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data + " ");
        }
    }

    public void bfs(Node localRoot) {
        
        Queue<Node> queue = new LinkedList<>();

        if (localRoot != null) {
            queue.add(localRoot);
        }

        while (!queue.isEmpty()) {
            
            localRoot = queue.remove();

            System.out.print(localRoot.data + " ");

            if (localRoot.right != null) {
                queue.add(localRoot.right);
            }
            if (localRoot.left != null) {
                queue.add(localRoot.left);
            }
        }
    }
}
