package com.thealgorithms.greedyalgorithms;

import java.util.ArrayList;
import java.util.List;

public final class EgyptianFraction {
    private EgyptianFraction() {
    }

    public static List<String> getEgyptianFraction(int numerator, int denominator) {
        List<String> result = new ArrayList<>();
        while (numerator != 0) {
            int x = (int) Math.ceil((double) denominator / numerator);
            result.add("1/" + x);
            numerator = numerator * x - denominator;
            denominator = denominator * x;
        }
        return result;
    }
}
