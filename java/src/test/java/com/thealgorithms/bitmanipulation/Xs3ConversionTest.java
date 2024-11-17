package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Xs3ConversionTest {

    @Test
    public void testXs3ToBinary() {
        int binary = Xs3Conversion.xs3ToBinary(0x4567);
        assertEquals(1234, binary); 
    }

    @Test
    public void testBinaryToXs3() {
        int xs3 = Xs3Conversion.binaryToXs3(1234);
        assertEquals(0x4567, xs3); 
    }

    @Test
    public void testXs3ToBinaryZero() {
        int binary = Xs3Conversion.xs3ToBinary(0x0);
        assertEquals(0, binary); 
    }

    @Test
    public void testBinaryToXs3Zero() {
        int xs3 = Xs3Conversion.binaryToXs3(0);
        assertEquals(0x0, xs3); 
    }

    @Test
    public void testXs3ToBinarySingleDigit() {
        int binary = Xs3Conversion.xs3ToBinary(0x5);
        assertEquals(2, binary); 
    }

    @Test
    public void testBinaryToXs3SingleDigit() {
        int xs3 = Xs3Conversion.binaryToXs3(2);
        assertEquals(0x5, xs3); 
    }
}
