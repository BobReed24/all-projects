package com.thealgorithms.datastructures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {

    private static final class Node {

        int data;
        ArrayList<Node> child = new ArrayList<>();
    }

    private final Node root;

    public GenericTree() { 
        Scanner scn = new Scanner(System.in);
        root = createTreeG(null, 0, scn);
    }

    private Node createTreeG(Node node, int childIndex, Scanner scanner) {
        
        if (node == null) {
            System.out.println("Enter root's data");
        } else {
            System.out.println("Enter data of parent of index " + node.data + " " + childIndex);
        }
        
        node = new Node();
        node.data = scanner.nextInt();
        System.out.println("number of children");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            Node child = createTreeG(node, i, scanner);
            node.child.add(child);
        }
        return node;
    }

    public void display() { 
        display1(root);
    }

    private void display1(Node parent) {
        System.out.print(parent.data + "=>");
        for (int i = 0; i < parent.child.size(); i++) {
            System.out.print(parent.child.get(i).data + " ");
        }
        System.out.println(".");
        for (int i = 0; i < parent.child.size(); i++) {
            display1(parent.child.get(i));
        }
    }

    public int size2call() {
        return size2(root);
    }

    public int size2(Node roott) {
        int sz = 0;
        for (int i = 0; i < roott.child.size(); i++) {
            sz += size2(roott.child.get(i));
        }
        return sz + 1;
    }

    public int maxcall() {
        int maxi = root.data;
        return max(root, maxi);
    }

    private int max(Node roott, int maxi) {
        if (maxi < roott.data) {
            maxi = roott.data;
        }
        for (int i = 0; i < roott.child.size(); i++) {
            maxi = max(roott.child.get(i), maxi);
        }

        return maxi;
    }

    public int heightcall() {
        return height(root) - 1;
    }

    private int height(Node node) {
        int h = 0;
        for (int i = 0; i < node.child.size(); i++) {
            int k = height(node.child.get(i));
            if (k > h) {
                h = k;
            }
        }
        return h + 1;
    }

    public boolean findcall(int info) {
        return find(root, info);
    }

    private boolean find(Node node, int info) {
        if (node.data == info) {
            return true;
        }
        for (int i = 0; i < node.child.size(); i++) {
            if (find(node.child.get(i), info)) {
                return true;
            }
        }
        return false;
    }

    public void depthcaller(int dep) {
        depth(root, dep);
    }

    public void depth(Node node, int dep) {
        if (dep == 0) {
            System.out.println(node.data);
            return;
        }
        for (int i = 0; i < node.child.size(); i++) {
            depth(node.child.get(i), dep - 1);
        }
    }

    public void preordercall() {
        preorder(root);
        System.out.println(".");
    }

    private void preorder(Node node) {
        System.out.print(node.data + " ");
        for (int i = 0; i < node.child.size(); i++) {
            preorder(node.child.get(i));
        }
    }

    public void postordercall() {
        postorder(root);
        System.out.println(".");
    }

    private void postorder(Node node) {
        for (int i = 0; i < node.child.size(); i++) {
            postorder(node.child.get(i));
        }
        System.out.print(node.data + " ");
    }

    public void levelorder() {
        LinkedList<Node> q = new LinkedList<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int k = q.getFirst().data;
            System.out.print(k + " ");

            for (int i = 0; i < q.getFirst().child.size(); i++) {
                q.addLast(q.getFirst().child.get(i));
            }
            q.removeFirst();
        }
        System.out.println(".");
    }

    public void removeleavescall() {
        removeleaves(root);
    }

    private void removeleaves(Node node) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < node.child.size(); i++) {
            if (node.child.get(i).child.size() == 0) {
                arr.add(i);
            } else {
                removeleaves(node.child.get(i));
            }
        }
        for (int i = arr.size() - 1; i >= 0; i--) {
            node.child.remove(arr.get(i) + 0);
        }
    }
}
