package com.thealgorithms.maths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibonacciNumberCheckTest {
    @Test
    public void testNumberIsFibonacciNumber() {
        Assertions.assertTrue(FibonacciNumberCheck.isFibonacciNumber(1));
        Assertions.assertTrue(FibonacciNumberCheck.isFibonacciNumber(2));
        Assertions.assertTrue(FibonacciNumberCheck.isFibonacciNumber(21));
        Assertions.assertTrue(FibonacciNumberCheck.isFibonacciNumber(6765)); 
        Assertions.assertTrue(FibonacciNumberCheck.isFibonacciNumber(832040)); 
        Assertions.assertTrue(FibonacciNumberCheck.isFibonacciNumber(102334155)); 
        Assertions.assertTrue(FibonacciNumberCheck.isFibonacciNumber(701408733)); 
    }

    @Test
    public void testNumberIsNotFibonacciNumber() {
        Assertions.assertFalse(FibonacciNumberCheck.isFibonacciNumber(9));
        Assertions.assertFalse(FibonacciNumberCheck.isFibonacciNumber(10));
        Assertions.assertFalse(FibonacciNumberCheck.isFibonacciNumber(145));
        Assertions.assertFalse(FibonacciNumberCheck.isFibonacciNumber(701408734));
    }
}
