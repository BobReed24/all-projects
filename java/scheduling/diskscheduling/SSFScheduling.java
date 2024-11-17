package com.thealgorithms.scheduling.diskscheduling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SSFScheduling {
    private int currentPosition;

    public SSFScheduling(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public List<Integer> execute(Collection<Integer> requests) {
        List<Integer> result = new ArrayList<>(requests);
        List<Integer> orderedRequests = new ArrayList<>();

        while (!result.isEmpty()) {
            int closest = findClosest(result);
            orderedRequests.add(closest);
            result.remove(Integer.valueOf(closest));
            currentPosition = closest;
        }
        return orderedRequests;
    }

    private int findClosest(List<Integer> requests) {
        int minDistance = Integer.MAX_VALUE;
        int closest = -1;
        for (int request : requests) {
            int distance = Math.abs(currentPosition - request);
            if (distance < minDistance) {
                minDistance = distance;
                closest = request;
            }
        }
        return closest;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
