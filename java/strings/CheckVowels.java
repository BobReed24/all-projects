package com.thealgorithms.strings;

import java.util.Set;

public final class CheckVowels {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    private CheckVowels() {
    }

    public static boolean hasVowels(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        for (char c : input.toLowerCase().toCharArray()) {
            if (VOWELS.contains(c)) {
                return true;
            }
        }
        return false;
    }
}
