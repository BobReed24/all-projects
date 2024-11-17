package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IndexOfRightMostSetBitTest {

    @Test
    void testIndexOfRightMostSetBit() {
        assertEquals(3, IndexOfRightMostSetBit.indexOfRightMostSetBit(40));
        assertEquals(-1, IndexOfRightMostSetBit.indexOfRightMostSetBit(0));
        assertEquals(3, IndexOfRightMostSetBit.indexOfRightMostSetBit(-40));
    }
}
