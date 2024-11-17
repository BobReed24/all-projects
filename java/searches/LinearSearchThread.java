package com.thealgorithms.searches;

public final class LinearSearchThread {
    private LinearSearchThread() {
    }
}

class Searcher extends Thread {
    private final int[] arr; 
    private final int left; 
    private final int right; 
    private final int x; 
    private boolean found; 

    Searcher(int[] arr, int left, int right, int x) {
        this.arr = arr;
        this.left = left;
        this.right = right;
        this.x = x;
    }

    @Override
    public void run() {
        int k = left;
        found = false;
        while (k < right && !found) {
            if (arr[k++] == x) {
                found = true;
            }
        }
    }

    boolean getResult() {
        return found;
    }
}
