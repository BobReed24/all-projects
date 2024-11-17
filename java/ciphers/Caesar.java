package com.thealgorithms.ciphers;

public class Caesar {

    public String encode(String message, int shift) {
        StringBuilder encoded = new StringBuilder();

        shift %= 26;

        final int length = message.length();
        for (int i = 0; i < length; i++) {
            
            char current = message.charAt(i); 

            if (isCapitalLatinLetter(current)) {
                current += shift;
                encoded.append((char) (current > 'Z' ? current - 26 : current)); 
            } else if (isSmallLatinLetter(current)) {
                current += shift;
                encoded.append((char) (current > 'z' ? current - 26 : current)); 
            } else {
                encoded.append(current);
            }
        }
        return encoded.toString();
    }

    public String decode(String encryptedMessage, int shift) {
        StringBuilder decoded = new StringBuilder();

        shift %= 26;

        final int length = encryptedMessage.length();
        for (int i = 0; i < length; i++) {
            char current = encryptedMessage.charAt(i);
            if (isCapitalLatinLetter(current)) {
                current -= shift;
                decoded.append((char) (current < 'A' ? current + 26 : current)); 
            } else if (isSmallLatinLetter(current)) {
                current -= shift;
                decoded.append((char) (current < 'a' ? current + 26 : current)); 
            } else {
                decoded.append(current);
            }
        }
        return decoded.toString();
    }

    private static boolean isCapitalLatinLetter(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static boolean isSmallLatinLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    public String[] bruteforce(String encryptedMessage) {
        String[] listOfAllTheAnswers = new String[27];
        for (int i = 0; i <= 26; i++) {
            listOfAllTheAnswers[i] = decode(encryptedMessage, i);
        }

        return listOfAllTheAnswers;
    }
}
