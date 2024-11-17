package com.thealgorithms.others;

public final class RemoveDuplicateFromString {
    private RemoveDuplicateFromString() {
    }

    public static String removeDuplicate(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder uniqueChars = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (uniqueChars.indexOf(String.valueOf(c)) == -1) {
                uniqueChars.append(c); 
            }
        }

        return uniqueChars.toString();
    }
}
