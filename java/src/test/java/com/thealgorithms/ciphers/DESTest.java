package com.thealgorithms.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DESTest {

    DES des;

    @BeforeEach
    public void setUp() {
        des = new DES("0000111000110010100100100011001011101010011011010000110101110011");
    }

    @Test
    void testEncrypt() {
        
        String plainText = "Your lips are smoother than vaseline\r\n";
        
        String expectedOutput = "11000000100110011001111111011101111000110111100011010111111"
            + "011010111001001111101101000000000101111001010010110101000010011101110010001111111001"
            + "001101001101001001101011001000011100000011001000011011001110101010010111101111000111"
            + "101010011010110000100100110011000001010001010110010011011010001010011111000001110011001010011";

        String cipherText = des.encrypt(plainText);

        assertEquals(expectedOutput, cipherText);
    }

    @Test
    void testDecrypt() {
        
        String cipherText = "11000000100110011001111111011101111000110111100011010111111"
            + "011010111001001111101101000000000101111001010010110101000010011101110010001111111001"
            + "001101001101001001101011001000011100000011001000011011001110101010010111101111000111"
            + "101010011010110000100100110011000001010001010110010011011010001010011111000001110011001010011";
        String expectedOutput = "Your lips are smoother than vaseline\r\n";

        String plainText = des.decrypt(cipherText);

        assertEquals(expectedOutput, plainText);
    }
}
