package com.thealgorithms.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AutokeyCipherTest {

    Autokey autokeyCipher = new Autokey();

    @Test
    void autokeyEncryptTest() {
        
        String plaintext = "MEET AT DAWN";
        String keyword = "QUEEN";

        String cipherText = autokeyCipher.encrypt(plaintext, keyword);

        assertEquals("CYIXNFHEPN", cipherText);
    }

    @Test
    void autokeyDecryptTest() {
        
        String ciphertext = "CYIX NF HEPN";
        String keyword = "QUEEN";

        String plainText = autokeyCipher.decrypt(ciphertext, keyword);

        assertEquals("MEETATDAWN", plainText);
    }
}
