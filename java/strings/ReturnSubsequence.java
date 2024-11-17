package com.thealgorithms.strings;

public final class ReturnSubsequence {
    private ReturnSubsequence() {
    }

    public static String[] getSubsequences(String input) {
        if (input.isEmpty()) {
            return new String[] {""}; 
        }

        String[] smallerSubsequences = getSubsequences(input.substring(1));

        String[] result = new String[2 * smallerSubsequences.length];

        System.arraycopy(smallerSubsequences, 0, result, 0, smallerSubsequences.length);

        for (int i = 0; i < smallerSubsequences.length; i++) {
            result[i + smallerSubsequences.length] = input.charAt(0) + smallerSubsequences[i];
        }

        return result;
    }
}
