package com.thealgorithms.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PolybiusTest {

    @Test
    void testEncrypt() {
        
        String plaintext = "HELLOWORLD";

        String actual = Polybius.encrypt(plaintext);

        assertEquals("12042121244124322103", actual);
    }

    @Test
    void testDecrypt() {
        
        String ciphertext = "12042121244124322103";

        String actual = Polybius.decrypt(ciphertext);

        assertEquals("HELLOWORLD", actual);
    }

    @Test
    void testIsTextTheSameAfterEncryptionAndDecryption() {
        
        String plaintext = "HELLOWORLD";

        String encryptedText = Polybius.encrypt(plaintext);
        String actual = Polybius.decrypt(encryptedText);

        assertEquals(plaintext, actual);
    }
}
