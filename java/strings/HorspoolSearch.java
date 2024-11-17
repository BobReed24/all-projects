package com.thealgorithms.strings;

import java.util.HashMap;

public final class HorspoolSearch {
    private HorspoolSearch() {
    }

    private static HashMap<Character, Integer> shiftValues; 
    private static Integer patternLength;
    private static int comparisons = 0; 

    public static int findFirst(String pattern, String text) {
        return firstOccurrence(pattern, text, true);
    }

    public static int findFirstInsensitive(String pattern, String text) {
        return firstOccurrence(pattern, text, false);
    }

    public static Integer getLastComparisons() {
        return HorspoolSearch.comparisons;
    }

    private static int firstOccurrence(String pattern, String text, boolean caseSensitive) {
        shiftValues = calcShiftValues(pattern); 
        comparisons = 0; 

        if (pattern.length() == 0) { 
            return -1;
        }

        int textIndex = pattern.length() - 1; 

        while (textIndex < text.length()) {
            
            int i = pattern.length() - 1;
            while (i >= 0) {
                comparisons++;
                char patternChar = pattern.charAt(i);
                char textChar = text.charAt((textIndex + i) - (pattern.length() - 1));
                if (!charEquals(patternChar, textChar, caseSensitive)) { 
                    textIndex += getShiftValue(text.charAt(textIndex));
                    break;
                }
                i--;
            }

            if (i == -1) {
                return textIndex - pattern.length() + 1;
            }
        }

        return -1;
    }

    private static boolean charEquals(char c1, char c2, boolean caseSensitive) {
        if (caseSensitive) {
            return c1 == c2;
        }
        return Character.toLowerCase(c1) == Character.toLowerCase(c2);
    }

    private static HashMap<Character, Integer> calcShiftValues(String pattern) {
        patternLength = pattern.length();
        HashMap<Character, Integer> table = new HashMap<>();

        for (int i = pattern.length() - 2; i >= 0; i--) { 
            char c = pattern.charAt(i);
            int finalI = i;
            table.computeIfAbsent(c, k -> pattern.length() - 1 - finalI);
        }

        return table;
    }

    private static Integer getShiftValue(char c) {
        if (shiftValues.get(c) != null) {
            return shiftValues.get(c);
        } else {
            return patternLength;
        }
    }
}
