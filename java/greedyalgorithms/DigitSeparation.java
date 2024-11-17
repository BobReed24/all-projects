package com.thealgorithms.greedyalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DigitSeparation {
    public DigitSeparation() {
    }
    
    public List<Long> digitSeparationReverseOrder(long largeNumber) {
        List<Long> result = new ArrayList<>();
        if (largeNumber != 0) {
            while (largeNumber != 0) {
                result.add(Math.abs(largeNumber % 10));
                largeNumber = largeNumber / 10;
            }
        } else {
            result.add(0L);
        }
        return result;
    }
    
    public List<Long> digitSeparationForwardOrder(long largeNumber) {
        List<Long> result = this.digitSeparationReverseOrder(largeNumber);
        Collections.reverse(result);
        return result;
    }
}
