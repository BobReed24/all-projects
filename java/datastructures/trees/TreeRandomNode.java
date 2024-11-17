package com.thealgorithms.datastructures.trees;

import java.util.ArrayList;

public class TreeRandomNode {

    private final class Node {

        int item;
        Node left;
        Node right;
    }

    static ArrayList<Integer> list = new ArrayList<>();
    
    Node root;

    TreeRandomNode() {
        root = null;
    }

    static void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);

        list.add(node.item);
        
        inOrder(node.right);
    }

    public void getRandom(Node val) {
        inOrder(val);
        
        int n = list.size();
        int min = 0;
        int max = n - 1;
        
        int b = (int) (Math.random() * (max - min + 1) + min);
        
        int random = list.get(b);
        System.out.println("Random Node : " + random);
    }
}

