package com.thealgorithms.strings;

public final class CountChar {
    private CountChar() {
    }

    public static int countCharacters(String str) {
        if (str == null) {
            return 0;
        }
        return str.replaceAll("\\s", "").length();
    }
}
