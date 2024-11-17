package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumbersDifferentSignsTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testDifferentSigns(int num1, int num2, boolean expected) {
        if (expected) {
            assertTrue(NumbersDifferentSigns.differentSigns(num1, num2));
        } else {
            assertFalse(NumbersDifferentSigns.differentSigns(num1, num2));
        }
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            
            Arguments.of(2, -1, Boolean.TRUE), Arguments.of(-3, 7, Boolean.TRUE),

            Arguments.of(10, 20, Boolean.FALSE), Arguments.of(0, 5, Boolean.FALSE), 

            Arguments.of(-5, -8, Boolean.FALSE),

            Arguments.of(Integer.MAX_VALUE, Integer.MIN_VALUE, Boolean.TRUE),

            Arguments.of(-42, -42, Boolean.FALSE), Arguments.of(42, 42, Boolean.FALSE));
    }
}
