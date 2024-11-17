package com.thealgorithms.datastructures.heaps;

public class MinPriorityQueue {

    private final int[] heap;
    private final int capacity;
    private int size;

    public MinPriorityQueue(int c) {
        this.capacity = c;
        this.size = 0;
        this.heap = new int[c + 1];
    }

    public void insert(int key) {
        if (this.isFull()) {
            throw new IllegalStateException("MinPriorityQueue is full. Cannot insert new element.");
        }
        this.heap[this.size + 1] = key;
        int k = this.size + 1;
        while (k > 1) {
            if (this.heap[k] < this.heap[k / 2]) {
                int temp = this.heap[k];
                this.heap[k] = this.heap[k / 2];
                this.heap[k / 2] = temp;
            }
            k = k / 2;
        }
        this.size++;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("MinPriorityQueue is empty. Cannot peek.");
        }
        return this.heap[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void print() {
        for (int i = 1; i <= this.size; i++) {
            System.out.print(this.heap[i] + " ");
        }
        System.out.println();
    }

    public void heapSort() {
        for (int i = 1; i <= this.size; i++) {
            this.delete();
        }
    }

    private void sink() {
        int k = 1;
        while (2 * k <= this.size) {
            int minIndex = k; 

            if (2 * k <= this.size && this.heap[2 * k] < this.heap[minIndex]) {
                minIndex = 2 * k; 
            }
            if (2 * k + 1 <= this.size && this.heap[2 * k + 1] < this.heap[minIndex]) {
                minIndex = 2 * k + 1; 
            }

            if (minIndex == k) {
                break; 
            }

            int temp = this.heap[k];
            this.heap[k] = this.heap[minIndex];
            this.heap[minIndex] = temp;

            k = minIndex; 
        }
    }

    public int delete() {
        if (isEmpty()) {
            throw new IllegalStateException("MinPriorityQueue is empty. Cannot delete.");
        }
        int min = this.heap[1];
        this.heap[1] = this.heap[this.size]; 
        this.size--;
        this.sink();
        return min;
    }
}
