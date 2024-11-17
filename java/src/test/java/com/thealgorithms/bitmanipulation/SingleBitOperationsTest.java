package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SingleBitOperationsTest {

    @ParameterizedTest
    @MethodSource("provideFlipBitTestCases")
    void testFlipBit(int input, int bit, int expected) {
        assertEquals(expected, SingleBitOperations.flipBit(input, bit));
    }

    private static Stream<Arguments> provideFlipBitTestCases() {
        return Stream.of(Arguments.of(3, 1, 1), 
            Arguments.of(3, 3, 11) 
        );
    }

    @ParameterizedTest
    @MethodSource("provideSetBitTestCases")
    void testSetBit(int input, int bit, int expected) {
        assertEquals(expected, SingleBitOperations.setBit(input, bit));
    }

    private static Stream<Arguments> provideSetBitTestCases() {
        return Stream.of(Arguments.of(4, 0, 5), 
            Arguments.of(4, 2, 4), 
            Arguments.of(0, 1, 2), 
            Arguments.of(10, 2, 14) 
        );
    }

    @ParameterizedTest
    @MethodSource("provideClearBitTestCases")
    void testClearBit(int input, int bit, int expected) {
        assertEquals(expected, SingleBitOperations.clearBit(input, bit));
    }

    private static Stream<Arguments> provideClearBitTestCases() {
        return Stream.of(Arguments.of(7, 1, 5), 
            Arguments.of(5, 1, 5) 
        );
    }

    @ParameterizedTest
    @MethodSource("provideGetBitTestCases")
    void testGetBit(int input, int bit, int expected) {
        assertEquals(expected, SingleBitOperations.getBit(input, bit));
    }

    private static Stream<Arguments> provideGetBitTestCases() {
        return Stream.of(Arguments.of(6, 0, 0), 
            Arguments.of(7, 1, 1) 
        );
    }
}
