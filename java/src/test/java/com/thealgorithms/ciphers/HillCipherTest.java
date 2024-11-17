package com.thealgorithms.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HillCipherTest {

    HillCipher hillCipher = new HillCipher();

    @Test
    void hillCipherEncryptTest() {
        
        String message = "ACT"; 
        int[][] keyMatrix = {{6, 24, 1}, {13, 16, 10}, {20, 17, 15}}; 

        String cipherText = hillCipher.encrypt(message, keyMatrix);

        assertEquals("POH", cipherText);
    }

    @Test
    void hillCipherDecryptTest() {
        
        String cipherText = "POH"; 
        int[][] inverseKeyMatrix = {{8, 5, 10}, {21, 8, 21}, {21, 12, 8}}; 

        String plainText = hillCipher.decrypt(cipherText, inverseKeyMatrix);

        assertEquals("ACT", plainText);
    }
}
