package com.thealgorithms.strings;

public final class HammingDistance {
    private HammingDistance() {
    }

    public static int calculateHammingDistance(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }

        if (s1.length() != s2.length()) {
            throw new IllegalArgumentException("String lengths must be equal");
        }

        int distance = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}
