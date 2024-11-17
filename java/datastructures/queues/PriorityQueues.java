package com.thealgorithms.datastructures.queues;

class PriorityQueue {

    private int maxSize;
    
    private int[] queueArray;
    
    private int nItems;

    PriorityQueue() {
        
        int size = 11; 
        maxSize = size + 1;
        queueArray = new int[maxSize];
        nItems = 0;
    }

    PriorityQueue(int size) {
        maxSize = size + 1;
        queueArray = new int[maxSize];
        nItems = 0;
    }

    private void swim(int pos) {
        
        while (pos > 1 && (queueArray[pos / 2] < queueArray[pos])) {
            
            int temp = queueArray[pos];
            queueArray[pos] = queueArray[pos / 2];
            queueArray[pos / 2] = temp;
            pos = pos / 2; 
        }
        
    }

    private void sink(int pos) {
        
        while (2 * pos <= nItems) {
            int current = 2 * pos; 
            
            if (current < nItems && queueArray[current] < queueArray[current + 1]) {
                current++;
            }
            
            if (queueArray[pos] >= queueArray[current]) {
                break;
            }

            int temp = queueArray[pos];
            queueArray[pos] = queueArray[current];
            queueArray[current] = temp;
            pos = current; 
        }
    }

    public void insert(int value) {
        
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        } else {
            queueArray[++nItems] = value;
            swim(nItems); 
        }
    }

    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        } else {
            int max = queueArray[1]; 
                                     
            int temp = queueArray[1];
            queueArray[1] = queueArray[nItems];
            queueArray[nItems] = temp;
            queueArray[nItems--] = 0; 
            sink(1); 

            return max;
        }
    }

    public int peek() {
        return queueArray[1];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize - 1);
    }

    public int getSize() {
        return nItems;
    }
}
