package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class KrishnamurthyNumberTest {

    @Test
    public void testIsKrishnamurthyTrue() {
        assertTrue(KrishnamurthyNumber.isKrishnamurthy(145));
    }

    @Test
    public void testIsKrishnamurthyFalse() {
        assertFalse(KrishnamurthyNumber.isKrishnamurthy(123));
    }

    @Test
    public void testIsKrishnamurthyZero() {
        assertFalse(KrishnamurthyNumber.isKrishnamurthy(0));
    }

    @Test
    public void testIsKrishnamurthyNegative() {
        assertFalse(KrishnamurthyNumber.isKrishnamurthy(-145));
    }

    @Test
    public void testIsKrishnamurthySingleDigitTrue() {
        assertTrue(KrishnamurthyNumber.isKrishnamurthy(1));
        assertTrue(KrishnamurthyNumber.isKrishnamurthy(2));
    }

    @Test
    public void testIsKrishnamurthySingleDigitFalse() {
        assertFalse(KrishnamurthyNumber.isKrishnamurthy(3));
        assertFalse(KrishnamurthyNumber.isKrishnamurthy(4));
    }
}
