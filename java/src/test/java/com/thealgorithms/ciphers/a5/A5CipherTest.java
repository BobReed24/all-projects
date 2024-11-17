package com.thealgorithms.ciphers.a5;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.BitSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class A5CipherTest {

    private A5Cipher a5Cipher;

    @BeforeEach
    void setUp() {
        
        final var sessionKey = BitSet.valueOf(new long[] {0b1010101010101010L});
        final var frameCounter = BitSet.valueOf(new long[] {0b0000000000000001L});
        a5Cipher = new A5Cipher(sessionKey, frameCounter);
    }

    @Test
    void testEncryptWithValidInput() {
        BitSet plainText = BitSet.valueOf(new long[] {0b1100110011001100L}); 
        BitSet encrypted = a5Cipher.encrypt(plainText);

        assertNotEquals(plainText, encrypted, "Encrypted output should not equal plaintext");
    }

    @Test
    void testEncryptAllOnesInput() {
        BitSet plainText = BitSet.valueOf(new long[] {0b1111111111111111L}); 
        BitSet encrypted = a5Cipher.encrypt(plainText);

        assertNotEquals(plainText, encrypted, "Encrypted output should not equal plaintext of all ones");
    }

    @Test
    void testEncryptAllZerosInput() {
        BitSet plainText = new BitSet(); 
        BitSet encrypted = a5Cipher.encrypt(plainText);

        assertNotEquals(plainText, encrypted, "Encrypted output should not equal plaintext of all zeros");
    }
}
