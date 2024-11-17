package com.thealgorithms.conversions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HexaDecimalToDecimalTest {

    @ParameterizedTest
    @CsvSource({
        "A1, 161", 
        "1AC, 428", 
        "0, 0", 
        "F, 15", 
        "10, 16", 
        "FFFF, 65535", 
        "7FFFFFFF, 2147483647" 
    })
    public void
    testValidHexaToDecimal(String hexInput, int expectedDecimal) {
        assertEquals(expectedDecimal, HexaDecimalToDecimal.getHexaToDec(hexInput));
    }

    @ParameterizedTest
    @CsvSource({
        "G", 
        "1Z", 
        "123G", 
        "#$%" 
    })
    public void
    testInvalidHexaToDecimal(String invalidHex) {
        assertThrows(IllegalArgumentException.class, () -> HexaDecimalToDecimal.getHexaToDec(invalidHex));
    }
}
