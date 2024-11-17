package com.thealgorithms.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void testLengthOfLongestSubstring() {
        
        assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
        assertEquals(0, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(""));
        assertEquals(5, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcde"));
    }
}
