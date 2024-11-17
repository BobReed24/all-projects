package com.thealgorithms.bitmanipulation;

public final class OnesComplement {
    private OnesComplement() {
    }

    public static String onesComplement(String binary) {
        StringBuilder complement = new StringBuilder();
        
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                complement.append('1');
            } else {
                complement.append('0');
            }
        }
        return complement.toString();
    }
}
