package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GrayCodeConversionTest {

    @Test
    public void testBinaryToGray() {
        assertEquals(7, GrayCodeConversion.binaryToGray(5)); 
        assertEquals(4, GrayCodeConversion.binaryToGray(7)); 
        assertEquals(1, GrayCodeConversion.binaryToGray(1)); 
    }

    @Test
    public void testGrayToBinary() {
        assertEquals(5, GrayCodeConversion.grayToBinary(7)); 
        assertEquals(4, GrayCodeConversion.grayToBinary(6)); 
        assertEquals(1, GrayCodeConversion.grayToBinary(1)); 
    }

    @Test
    public void testBinaryGrayCycle() {
        int binary = 9; 
        int gray = GrayCodeConversion.binaryToGray(binary);
        assertEquals(binary, GrayCodeConversion.grayToBinary(gray)); 
    }
}
