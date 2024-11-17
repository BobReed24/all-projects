package com.thealgorithms.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CaesarTest {

    Caesar caesar = new Caesar();

    @Test
    void caesarEncryptTest() {
        
        String textToEncrypt = "Encrypt this text";

        String cipherText = caesar.encode(textToEncrypt, 5);

        assertEquals("Jshwduy ymnx yjcy", cipherText);
    }

    @Test
    void caesarDecryptTest() {
        
        String encryptedText = "Jshwduy ymnx yjcy";

        String cipherText = caesar.decode(encryptedText, 5);

        assertEquals("Encrypt this text", cipherText);
    }

    @Test
    void caesarBruteForce() {
        
        String encryptedText = "Jshwduy ymnx yjcy";

        String[] allPossibleAnswers = caesar.bruteforce(encryptedText);

        assertEquals(27, allPossibleAnswers.length);
        assertEquals("Encrypt this text", allPossibleAnswers[5]);
    }
}
