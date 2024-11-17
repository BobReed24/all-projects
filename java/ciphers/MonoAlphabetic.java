package com.thealgorithms.ciphers;

public final class MonoAlphabetic {

    private MonoAlphabetic() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String encrypt(String data, String key) {
        if (!data.matches("[A-Z]+")) {
            throw new IllegalArgumentException("Input data contains invalid characters. Only uppercase A-Z are allowed.");
        }
        StringBuilder sb = new StringBuilder();

        for (char c : data.toCharArray()) {
            int idx = charToPos(c); 
            sb.append(key.charAt(idx)); 
        }
        return sb.toString();
    }

    public static String decrypt(String data, String key) {
        StringBuilder sb = new StringBuilder();

        for (char c : data.toCharArray()) {
            int idx = key.indexOf(c); 
            if (idx == -1) {
                throw new IllegalArgumentException("Input data contains invalid characters.");
            }
            sb.append(posToChar(idx)); 
        }
        return sb.toString();
    }

    private static int charToPos(char c) {
        return c - 'A'; 
    }

    private static char posToChar(int pos) {
        return (char) (pos + 'A'); 
    }
}
