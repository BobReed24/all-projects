package com.thealgorithms.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BlowfishTest {

    Blowfish blowfish = new Blowfish();

    @Test
    void testEncrypt() {
        
        String plainText = "123456abcd132536";
        String key = "aabb09182736ccdd";
        String expectedOutput = "d748ec383d3405f7";

        String cipherText = blowfish.encrypt(plainText, key);

        assertEquals(expectedOutput, cipherText);
    }

    @Test
    void testDecrypt() {
        
        String cipherText = "d748ec383d3405f7";
        String key = "aabb09182736ccdd";
        String expectedOutput = "123456abcd132536";

        String plainText = blowfish.decrypt(cipherText, key);

        assertEquals(expectedOutput, plainText);
    }
}
