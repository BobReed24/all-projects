package com.thealgorithms.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BaconianCipherTest {

    BaconianCipher baconianCipher = new BaconianCipher();

    @Test
    void baconianCipherEncryptTest() {
        
        String plaintext = "MEET AT DAWN";

        String cipherText = baconianCipher.encrypt(plaintext);

        assertEquals("ABBAAAABAAAABAABAABBAAAAABAABBAAABBAAAAABABBAABBAB", cipherText);
    }

    @Test
    void baconianCipherDecryptTest() {
        
        String ciphertext = "ABBAAAABAAAABAABAABBAAAAABAABBAAABBAAAAABABBAABBAB";

        String plainText = baconianCipher.decrypt(ciphertext);

        assertEquals("MEETATDAWN", plainText);
    }
}
