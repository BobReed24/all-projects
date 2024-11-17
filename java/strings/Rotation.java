package com.thealgorithms.strings;

public final class Rotation {
    private Rotation() {
    }

    public static void main(String[] args) {
        assert rotation("abcdef", 2).equals("cdefab");

        char[] values = "abcdef".toCharArray();
        rotation(values, 2);
        assert new String(values).equals("cdefab");
    }

    public static String rotation(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public static void rotation(char[] values, int n) {
        reverse(values, 0, n - 1);
        reverse(values, n, values.length - 1);
        reverse(values, 0, values.length - 1);
    }

    public static void reverse(char[] values, int from, int to) {
        while (from < to) {
            char temp = values[from];
            values[from] = values[to];
            values[to] = temp;
            from++;
            to--;
        }
    }
}
