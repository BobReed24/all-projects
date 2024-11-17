package com.thealgorithms.strings;

public final class ReverseStringRecursive {
    private ReverseStringRecursive() {
    }

    public static String reverse(String str) {
        if (str.isEmpty()) {
            return str;
        } else {
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }
}
