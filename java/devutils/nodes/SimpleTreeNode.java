package com.thealgorithms.devutils.nodes;

public class SimpleTreeNode<E> extends TreeNode<E> {

    private SimpleTreeNode<E> leftNode;
    
    private SimpleTreeNode<E> rightNode;

    public SimpleTreeNode() {
        super();
    }

    public SimpleTreeNode(E data) {
        super(data);
    }

    public SimpleTreeNode(E data, SimpleTreeNode<E> parentNode) {
        super(data, parentNode);
    }

    public SimpleTreeNode(E data, SimpleTreeNode<E> parentNode, SimpleTreeNode<E> leftNode, SimpleTreeNode<E> rightNode) {
        super(data, parentNode);
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public boolean isLeafNode() {
        return (leftNode == null && rightNode == null);
    }

    public SimpleTreeNode<E> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(SimpleTreeNode<E> leftNode) {
        this.leftNode = leftNode;
    }

    public SimpleTreeNode<E> getRightNode() {
        return rightNode;
    }

    public void setRightNode(SimpleTreeNode<E> rightNode) {
        this.rightNode = rightNode;
    }
}
