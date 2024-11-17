package com.thealgorithms.strings;

import java.util.HashSet;
import java.util.Set;

public final class PermuteString {
    private PermuteString() {
    }

    public static Set<String> getPermutations(String str) {
        Set<String> permutations = new HashSet<>();
        generatePermutations(str, 0, str.length(), permutations);
        return permutations;
    }

    private static void generatePermutations(String str, int start, int end, Set<String> permutations) {
        if (start == end - 1) {
            permutations.add(str);
        } else {
            for (int currentIndex = start; currentIndex < end; currentIndex++) {
                
                str = swapCharacters(str, start, currentIndex);
                
                generatePermutations(str, start + 1, end, permutations);
                
                str = swapCharacters(str, start, currentIndex);
            }
        }
    }

    private static String swapCharacters(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
