package com.thealgorithms.strings;

public final class Lower {
    private Lower() {
    }

    public static void main(String[] args) {
        String[] strings = {"ABC", "ABC123", "abcABC", "abc123ABC"};
        for (String s : strings) {
            assert toLowerCase(s).equals(s.toLowerCase());
        }
    }

    public static String toLowerCase(String s) {
        char[] values = s.toCharArray();
        for (int i = 0; i < values.length; ++i) {
            if (Character.isLetter(values[i]) && Character.isUpperCase(values[i])) {
                values[i] = Character.toLowerCase(values[i]);
            }
        }
        return new String(values);
    }
}
