package com.thealgorithms.strings;

import java.util.Arrays;
import java.util.Collections;

public final class ReverseWordsInString {

    private ReverseWordsInString() {
    }

    public static String reverseWordsInString(final String s) {
        var words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
