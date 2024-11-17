package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SwapAdjacentBitsTest {

    @ParameterizedTest
    @CsvSource({"2, 1", 
        "43, 23", 
        "153, 102", 
        "15, 15", 
        "0, 0", 
        "1, 2", 
        "170, 85", 
        "85, 170", 
        "255, 255", 
        "128, 64", 
        "1024, 2048",
        "-1, -1", 
        "-2, -3", 
        "2147483647, -1073741825", "-2147483648, -1073741824"})
    void
    testSwapAdjacentBits(int input, int expected) {
        assertEquals(expected, SwapAdjacentBits.swapAdjacentBits(input));
    }
}
