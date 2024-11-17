package com.thealgorithms.devutils.nodes;

public abstract class TreeNode<E> extends Node<E> {

    private TreeNode<E> parentNode;
    
    private int depth;

    public TreeNode() {
        super();
        depth = 0;
    }

    public TreeNode(E data) {
        super(data);
        depth = 0;
    }

    public TreeNode(E data, TreeNode<E> parentNode) {
        super(data);
        this.parentNode = parentNode;
        depth = this.parentNode.getDepth() + 1;
    }

    public abstract boolean isLeafNode();

    public boolean isRootNode() {
        return (parentNode == null);
    }

    public TreeNode<E> getParent() {
        return parentNode;
    }

    public void setParent(TreeNode<E> parentNode) {
        this.parentNode = parentNode;
        depth = this.parentNode.getDepth() + 1;
    }

    public int getDepth() {
        return depth;
    }
}
