package com.thealgorithms.ciphers.a5;

import static com.thealgorithms.ciphers.a5.A5KeyStreamGenerator.FRAME_COUNTER_LENGTH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.BitSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class A5KeyStreamGeneratorTest {

    private A5KeyStreamGenerator keyStreamGenerator;
    private BitSet frameCounter;

    @BeforeEach
    void setUp() {
        keyStreamGenerator = new A5KeyStreamGenerator();

        final var sessionKey = BitSet.valueOf(new long[] {0b1010101010101010L}); 
        frameCounter = BitSet.valueOf(new long[] {0b0000000000000001L}); 
        keyStreamGenerator.initialize(sessionKey, frameCounter);
    }

    @Test
    void testInitialization() {
        
        assertNotNull(keyStreamGenerator, "KeyStreamGenerator should be initialized");
    }

    @Test
    void testIncrementFrameCounter() {
        
        keyStreamGenerator.getNextKeyStream();

        BitSet incrementedFrameCounter = keyStreamGenerator.getFrameCounter();

        BitSet expectedFrameCounter = (BitSet) frameCounter.clone();
        Utils.increment(expectedFrameCounter, FRAME_COUNTER_LENGTH);

        assertEquals(expectedFrameCounter, incrementedFrameCounter, "Frame counter should be incremented after generating key stream");
    }

    @Test
    void testGetNextKeyStreamProducesDifferentOutputs() {
        
        BitSet firstKeyStream = keyStreamGenerator.getNextKeyStream();

        BitSet secondKeyStream = keyStreamGenerator.getNextKeyStream();

        assertNotEquals(firstKeyStream, secondKeyStream, "Consecutive key streams should be different");
    }
}
