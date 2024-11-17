package com.thealgorithms.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RailFenceTest {

    @Test
    void testEncryption() {
        RailFenceCipher cipher = new RailFenceCipher();

        String input = "We are discovered! Flee at once";
        int rails = 3;
        String encrypted = cipher.encrypt(input, rails);
        assertEquals("Wrivdlaneaedsoee!Fe toc  cr e e", encrypted);

        String singleChar = "A";
        int singleRail = 2;
        String encryptedSingleChar = cipher.encrypt(singleChar, singleRail);
        assertEquals("A", encryptedSingleChar);

        String shortString = "Hello";
        int moreRails = 10;
        String encryptedShortString = cipher.encrypt(shortString, moreRails);
        assertEquals("Hello", encryptedShortString);

        String inputSingleRail = "Single line";
        int singleRailOnly = 1;
        String encryptedSingleRail = cipher.encrypt(inputSingleRail, singleRailOnly);
        assertEquals("Single line", encryptedSingleRail);
    }

    @Test
    void testDecryption() {
        RailFenceCipher cipher = new RailFenceCipher();

        String encryptedInput = "Wrivdlaneaedsoee!Fe toc  cr e e";
        int rails = 3;
        String decrypted = cipher.decrypt(encryptedInput, rails);
        assertEquals("We are discovered! Flee at once", decrypted);

        String encryptedSingleChar = "A";
        int singleRail = 2; 
        String decryptedSingleChar = cipher.decrypt(encryptedSingleChar, singleRail);
        assertEquals("A", decryptedSingleChar);

        String encryptedShortString = "Hello";
        int moreRails = 10; 
        String decryptedShortString = cipher.decrypt(encryptedShortString, moreRails);
        assertEquals("Hello", decryptedShortString);

        String encryptedSingleRail = "Single line";
        int singleRailOnly = 1;
        String decryptedSingleRail = cipher.decrypt(encryptedSingleRail, singleRailOnly);
        assertEquals("Single line", decryptedSingleRail);
    }
}
