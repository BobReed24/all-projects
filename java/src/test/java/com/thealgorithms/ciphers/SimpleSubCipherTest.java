package com.thealgorithms.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SimpleSubCipherTest {

    SimpleSubCipher simpleSubCipher = new SimpleSubCipher();

    @Test
    void simpleSubCipherEncryptTest() {
        
        String text = "defend the east wall of the castle";
        String cipherSmall = "phqgiumeaylnofdxjkrcvstzwb";

        String cipherText = simpleSubCipher.encode(text, cipherSmall);

        assertEquals("giuifg cei iprc tpnn du cei qprcni", cipherText);
    }

    @Test
    void simpleSubCipherDecryptTest() {
        
        String encryptedText = "giuifg cei iprc tpnn du cei qprcni";
        String cipherSmall = "phqgiumeaylnofdxjkrcvstzwb";

        String decryptedText = simpleSubCipher.decode(encryptedText, cipherSmall);

        assertEquals("defend the east wall of the castle", decryptedText);
    }
}
