package com.thealgorithms.strings;

import java.util.HashMap;
import java.util.Map;

final class LongestNonRepetitiveSubstring {
    private LongestNonRepetitiveSubstring() {
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                
                start = charIndexMap.get(currentChar) + 1;
            }

            charIndexMap.put(currentChar, i);

            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}
