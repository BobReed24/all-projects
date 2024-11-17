package com.thealgorithms.strings;

public final class CountWords {
    private CountWords() {
    }

    public static int wordCount(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        return s.trim().split("\\s+").length;
    }

    private static String removeSpecialCharacters(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c) || Character.isWhitespace(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static int secondaryWordCount(String s) {
        if (s == null) {
            return 0;
        }
        return wordCount(removeSpecialCharacters(s));
    }
}
