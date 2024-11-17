package com.thealgorithms.ciphers.a5;

import java.util.BitSet;

public class A5Cipher {

    private final A5KeyStreamGenerator keyStreamGenerator;
    private static final int KEY_STREAM_LENGTH = 228; 

    public A5Cipher(BitSet sessionKey, BitSet frameCounter) {
        keyStreamGenerator = new A5KeyStreamGenerator();
        keyStreamGenerator.initialize(sessionKey, frameCounter);
    }

    public BitSet encrypt(BitSet plainTextBits) {
        
        var result = new BitSet(KEY_STREAM_LENGTH);
        result.xor(plainTextBits);

        var key = keyStreamGenerator.getNextKeyStream();
        result.xor(key);

        return result;
    }

    public void resetCounter() {
        keyStreamGenerator.reInitialize();
    }
}
