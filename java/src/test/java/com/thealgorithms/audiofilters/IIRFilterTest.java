package com.thealgorithms.audiofilters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IIRFilterTest {

    @Test
    void testConstructorValidOrder() {
        
        IIRFilter filter = new IIRFilter(2);
        assertNotNull(filter, "Filter should be instantiated correctly");
    }

    @Test
    void testConstructorInvalidOrder() {
        
        assertThrows(IllegalArgumentException.class, () -> { new IIRFilter(0); }, "Order must be greater than zero");
    }

    @Test
    void testSetCoeffsInvalidLengthA() {
        IIRFilter filter = new IIRFilter(2);

        double[] aCoeffs = {1.0}; 
        double[] bCoeffs = {1.0, 0.5};
        assertThrows(IllegalArgumentException.class, () -> { filter.setCoeffs(aCoeffs, bCoeffs); }, "aCoeffs must be of size 2");
    }

    @Test
    void testSetCoeffsInvalidLengthB() {
        IIRFilter filter = new IIRFilter(2);

        double[] aCoeffs = {1.0, 0.5};
        double[] bCoeffs = {1.0}; 
        assertThrows(IllegalArgumentException.class, () -> { filter.setCoeffs(aCoeffs, bCoeffs); }, "bCoeffs must be of size 2");
    }

    @Test
    void testSetCoeffsInvalidACoeffZero() {
        IIRFilter filter = new IIRFilter(2);

        double[] aCoeffs = {0.0, 0.5}; 
        double[] bCoeffs = {1.0, 0.5};
        assertThrows(IllegalArgumentException.class, () -> { filter.setCoeffs(aCoeffs, bCoeffs); }, "aCoeffs[0] must not be zero");
    }

    @Test
    void testProcessWithNoCoeffsSet() {
        
        IIRFilter filter = new IIRFilter(2);
        double inputSample = 0.5;
        double result = filter.process(inputSample);

        assertEquals(inputSample, result, 1e-6, "Process should return the same value as input with default coefficients");
    }

    @Test
    void testProcessWithCoeffsSet() {
        
        IIRFilter filter = new IIRFilter(2);

        double[] aCoeffs = {1.0, 0.5};
        double[] bCoeffs = {1.0, 0.5};
        filter.setCoeffs(aCoeffs, bCoeffs);

        double inputSample = 0.5;
        double result = filter.process(inputSample);

        assertTrue(result >= -1.0 && result <= 1.0, "Processed result should be in the range [-1, 1]");
    }
}
