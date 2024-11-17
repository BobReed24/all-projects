package com.thealgorithms.ciphers;

public final class Polybius {
    private Polybius() {
    }

    private static final char[][] KEY = {
        
         {'A', 'B', 'C', 'D', 'E'},
         {'F', 'G', 'H', 'I', 'J'},
         {'K', 'L', 'M', 'N', 'O'},
         {'P', 'Q', 'R', 'S', 'T'},
         {'V', 'W', 'X', 'Y', 'Z'},
    };

    private static String findLocationByCharacter(final char character) {
        final StringBuilder location = new StringBuilder();
        for (int i = 0; i < KEY.length; i++) {
            for (int j = 0; j < KEY[i].length; j++) {
                if (character == KEY[i][j]) {
                    location.append(i).append(j);
                    break;
                }
            }
        }
        return location.toString();
    }

    public static String encrypt(final String plaintext) {
        final char[] chars = plaintext.toUpperCase().toCharArray();
        final StringBuilder ciphertext = new StringBuilder();
        for (char aChar : chars) {
            String location = findLocationByCharacter(aChar);
            ciphertext.append(location);
        }
        return ciphertext.toString();
    }

    public static String decrypt(final String ciphertext) {
        final char[] chars = ciphertext.toCharArray();
        final StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < chars.length; i += 2) {
            int pozitionX = Character.getNumericValue(chars[i]);
            int pozitionY = Character.getNumericValue(chars[i + 1]);
            plaintext.append(KEY[pozitionX][pozitionY]);
        }
        return plaintext.toString();
    }
}
