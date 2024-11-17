package com.thealgorithms.sorts;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class DutchNationalFlagSortTest {

    @Test
    
    void testOddDnfs() {
        Integer[] integers = {1, 3, 1, 4, 0};
        Integer[] integersResult = {0, 1, 1, 4, 3};
        DutchNationalFlagSort dutchNationalFlagSort = new DutchNationalFlagSort();
        dutchNationalFlagSort.sort(integers);
        assertArrayEquals(integers, integersResult);
    }

    @Test
    
    void testEvenDnfs() {
        Integer[] integers = {8, 1, 3, 1, 4, 0};
        Integer[] integersResult = {0, 1, 1, 3, 4, 8};
        DutchNationalFlagSort dutchNationalFlagSort = new DutchNationalFlagSort();
        dutchNationalFlagSort.sort(integers);
        assertArrayEquals(integers, integersResult);
    }

    @Test
    
    void testEvenStringsDnfs() {
        String[] strings = {"a", "d", "b", "s", "e", "e"};
        String[] stringsResult = {"a", "b", "s", "e", "e", "d"};
        DutchNationalFlagSort dutchNationalFlagSort = new DutchNationalFlagSort();
        dutchNationalFlagSort.sort(strings);
        assertArrayEquals(strings, stringsResult);
    }

    @Test
    
    void testOddStringsDnfs() {
        String[] strings = {"a", "d", "b", "s", "e"};
        String[] stringsResult = {"a", "b", "s", "e", "d"};
        DutchNationalFlagSort dutchNationalFlagSort = new DutchNationalFlagSort();
        dutchNationalFlagSort.sort(strings);
        assertArrayEquals(strings, stringsResult);
    }

    @Test
    
    void testOddMidGivenDnfs() {
        Integer[] integers = {1, 3, 1, 4, 0};
        Integer[] integersResult = {0, 1, 4, 3, 1};
        DutchNationalFlagSort dutchNationalFlagSort = new DutchNationalFlagSort();
        dutchNationalFlagSort.sort(integers, 0);
        assertArrayEquals(integers, integersResult);
    }

    @Test
    
    void testEvenMidGivenDnfs() {
        Integer[] integers = {8, 1, 3, 1, 4, 0};
        Integer[] integersResult = {0, 1, 3, 1, 4, 8};
        DutchNationalFlagSort dutchNationalFlagSort = new DutchNationalFlagSort();
        dutchNationalFlagSort.sort(integers, 4);
        assertArrayEquals(integers, integersResult);
    }

    @Test
    
    void testEvenStringsMidGivenDnfs() {
        String[] strings = {"a", "d", "b", "s", "e", "e"};
        String[] stringsResult = {"a", "d", "b", "e", "e", "s"};
        DutchNationalFlagSort dutchNationalFlagSort = new DutchNationalFlagSort();
        dutchNationalFlagSort.sort(strings, "s");
        assertArrayEquals(strings, stringsResult);
    }

    @Test
    
    void testOddStringsMidGivenDnfs() {
        String[] strings = {"a", "d", "b", "s", "e"};
        String[] stringsResult = {"a", "d", "b", "e", "s"};
        DutchNationalFlagSort dutchNationalFlagSort = new DutchNationalFlagSort();
        dutchNationalFlagSort.sort(strings, "e");
        assertArrayEquals(strings, stringsResult);
    }
}
