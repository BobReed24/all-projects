package com.thealgorithms.strings;

public final class Upper {
    private Upper() {
    }

    public static void main(String[] args) {
        String[] strings = {"ABC", "ABC123", "abcABC", "abc123ABC"};
        for (String s : strings) {
            assert toUpperCase(s).equals(s.toUpperCase());
        }
    }

    public static String toUpperCase(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] values = s.toCharArray();
        for (int i = 0; i < values.length; ++i) {
            if (Character.isLetter(values[i]) && Character.isLowerCase(values[i])) {
                values[i] = Character.toUpperCase(values[i]);
            }
        }
        return new String(values);
    }
}
