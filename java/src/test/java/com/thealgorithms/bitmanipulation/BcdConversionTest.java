package com.thealgorithms.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BcdConversionTest {

    @Test
    public void testBcdToDecimal() {
        int decimal = BcdConversion.bcdToDecimal(0x1234);
        assertEquals(1234, decimal); 
    }

    @Test
    public void testDecimalToBcd() {
        int bcd = BcdConversion.decimalToBcd(1234);
        assertEquals(0x1234, bcd); 
    }

    @Test
    public void testBcdToDecimalZero() {
        int decimal = BcdConversion.bcdToDecimal(0x0);
        assertEquals(0, decimal); 
    }

    @Test
    public void testDecimalToBcdZero() {
        int bcd = BcdConversion.decimalToBcd(0);
        assertEquals(0x0, bcd); 
    }

    @Test
    public void testBcdToDecimalSingleDigit() {
        int decimal = BcdConversion.bcdToDecimal(0x7);
        assertEquals(7, decimal); 
    }

    @Test
    public void testDecimalToBcdSingleDigit() {
        int bcd = BcdConversion.decimalToBcd(7);
        assertEquals(0x7, bcd); 
    }

    @Test
    public void testBcdToDecimalMaxValue() {
        int decimal = BcdConversion.bcdToDecimal(0x9999);
        assertEquals(9999, decimal); 
    }

    @Test
    public void testDecimalToBcdMaxValue() {
        int bcd = BcdConversion.decimalToBcd(9999);
        assertEquals(0x9999, bcd); 
    }

    @Test
    public void testBcdToDecimalInvalidHighDigit() {
        
        assertThrows(IllegalArgumentException.class, () -> {
            BcdConversion.bcdToDecimal(0x123A); 
        });
    }

    @Test
    public void testDecimalToBcdInvalidValue() {
        
        assertThrows(IllegalArgumentException.class, () -> {
            BcdConversion.decimalToBcd(10000); 
        });
    }

    @Test
    public void testBcdToDecimalLeadingZeroes() {
        int decimal = BcdConversion.bcdToDecimal(0x0234);
        assertEquals(234, decimal); 
    }

    @Test
    public void testDecimalToBcdLeadingZeroes() {
        int bcd = BcdConversion.decimalToBcd(234);
        assertEquals(0x0234, bcd); 
    }
}
