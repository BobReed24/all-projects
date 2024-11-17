package com.thealgorithms.greedyalgorithms;

import java.util.PriorityQueue;

public final class OptimalFileMerging {
    private OptimalFileMerging() {
    }

    public static int minMergeCost(int[] files) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int file : files) {
            minHeap.add(file);
        }

        int totalCost = 0;
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int cost = first + second;
            totalCost += cost;

            minHeap.add(cost);
        }
        return totalCost;
    }
}
