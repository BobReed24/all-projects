package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class IsPowerTwoTest {

    @ParameterizedTest
    @MethodSource("provideNumbersForPowerTwo")
    public void testIsPowerTwo(int number, boolean expected) {
        if (expected) {
            assertTrue(IsPowerTwo.isPowerTwo(number));
        } else {
            assertFalse(IsPowerTwo.isPowerTwo(number));
        }
    }

    private static Stream<Arguments> provideNumbersForPowerTwo() {
        return Stream.of(Arguments.of(1, Boolean.TRUE), 
            Arguments.of(2, Boolean.TRUE), 
            Arguments.of(4, Boolean.TRUE), 
            Arguments.of(8, Boolean.TRUE), 
            Arguments.of(16, Boolean.TRUE), 
            Arguments.of(32, Boolean.TRUE), 
            Arguments.of(64, Boolean.TRUE), 
            Arguments.of(128, Boolean.TRUE), 
            Arguments.of(256, Boolean.TRUE), 
            Arguments.of(1024, Boolean.TRUE), 
            Arguments.of(0, Boolean.FALSE), 
            Arguments.of(-1, Boolean.FALSE), 
            Arguments.of(-2, Boolean.FALSE), 
            Arguments.of(-4, Boolean.FALSE), 
            Arguments.of(3, Boolean.FALSE), 
            Arguments.of(5, Boolean.FALSE), 
            Arguments.of(6, Boolean.FALSE), 
            Arguments.of(15, Boolean.FALSE), 
            Arguments.of(1000, Boolean.FALSE), 
            Arguments.of(1023, Boolean.FALSE) 
        );
    }
}
