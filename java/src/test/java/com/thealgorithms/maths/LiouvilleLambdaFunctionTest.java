package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LiouvilleLambdaFunctionTest {

    @Test
    void testLiouvilleLambdaMustThrowExceptionIfNumberIsZero() {
        
        int number = 0;
        String expectedMessage = "Number must be greater than zero.";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> { LiouvilleLambdaFunction.liouvilleLambda(number); });
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testLiouvilleLambdaMustThrowExceptionIfNumberIsNegative() {
        
        int number = -1;
        String expectedMessage = "Number must be greater than zero.";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> { LiouvilleLambdaFunction.liouvilleLambda(number); });
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testLiouvilleLambdaMustReturnNegativeOne() {
        
        int number = 11;
        int expectedOutput = -1;

        int actualOutput = LiouvilleLambdaFunction.liouvilleLambda(number);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testLiouvilleLambdaMustReturnPositiveOne() {
        
        int number = 10;
        int expectedOutput = 1;

        int actualOutput = LiouvilleLambdaFunction.liouvilleLambda(number);

        assertEquals(expectedOutput, actualOutput);
    }
}
