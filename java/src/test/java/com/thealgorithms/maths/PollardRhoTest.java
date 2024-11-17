package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PollardRhoTest {

    @Test
    void testPollardRhoForNumber315MustReturn5() {
        
        int number = 315;
        int expectedResult = 5;

        int actualResult = PollardRho.pollardRho(number);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testPollardRhoForNumber187MustReturn11() {
        
        int number = 187;
        int expectedResult = 11;

        int actualResult = PollardRho.pollardRho(number);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testPollardRhoForNumber239MustThrowException() {
        
        int number = 239;
        String expectedMessage = "GCD cannot be found.";

        Exception exception = assertThrows(RuntimeException.class, () -> { PollardRho.pollardRho(number); });
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}
