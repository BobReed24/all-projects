package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MobiusFunctionTest {

    @Test
    void testMobiusForZero() {
        
        int number = 0;
        String expectedMessage = "Number must be greater than zero.";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> { MobiusFunction.mobius(number); });
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testMobiusForNegativeNumber() {
        
        int number = -1;
        String expectedMessage = "Number must be greater than zero.";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> { MobiusFunction.mobius(number); });
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testMobiusFunction() {
        int[] expectedResultArray = {
            1,
            -1,
            -1,
            0,
            -1,
            1,
            -1,
            0,
            0,
            1,
            -1,
            0,
            -1,
            1,
            1,
            0,
            -1,
            0,
            -1,
            0,
            1,
            1,
            -1,
            0,
            0,
            1,
            0,
            0,
            -1,
            -1,
            -1,
            0,
            1,
            1,
            1,
            0,
            -1,
            1,
            1,
            0,
            -1,
            -1,
            -1,
            0,
            0,
            1,
            -1,
            0,
            0,
            0,
            1,
            0,
            -1,
            0,
            1,
            0,
            1,
            1,
            -1,
            0,
            -1,
            1,
            0,
            0,
            1,
            -1,
            -1,
            0,
            1,
            -1,
            -1,
            0,
            -1,
            1,
            0,
            0,
            1,
            -1,
            -1,
            0,
            0,
            1,
            -1,
            0,
            1,
            1,
            1,
            0,
            -1,
            0,
            1,
            0,
            1,
            1,
            1,
            0,
            -1,
            0,
            0,
            0,
        };

        for (int i = 1; i <= 100; i++) {
            
            int expectedValue = expectedResultArray[i - 1];

            int actualValue = MobiusFunction.mobius(i);

            assertEquals(expectedValue, actualValue);
        }
    }
}
