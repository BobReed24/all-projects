package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NextHigherSameBitCountTest {

    @ParameterizedTest
    @CsvSource({
        "5, 6", 
        "7, 11", 
        "3, 5", 
        "12, 17", 
        "15, 23" 
    })
    void
    testNextHigherSameBitCount(int input, int expected) {
        assertEquals(expected, NextHigherSameBitCount.nextHigherSameBitCount(input));
    }
}
