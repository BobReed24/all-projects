package com.thealgorithms.datastructures.lists;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchSinglyLinkedListRecursionTest {

    private SearchSinglyLinkedListRecursion list;

    @BeforeEach
    public void setUp() {
        list = new SearchSinglyLinkedListRecursion();
    }

    @Test
    public void testSearchInEmptyList() {
        
        assertFalse(list.search(1));
    }

    @Test
    public void testSearchSingleElementListFound() {
        
        list.insert(5);
        assertTrue(list.search(5));
    }

    @Test
    public void testSearchSingleElementListNotFound() {
        
        list.insert(5);
        assertFalse(list.search(10));
    }

    @Test
    public void testSearchMultipleElementsListFound() {
        
        for (int i = 1; i <= 10; i++) {
            list.insert(i);
        }
        assertTrue(list.search(5));
    }

    @Test
    public void testSearchMultipleElementsListFirstElement() {
        
        for (int i = 1; i <= 10; i++) {
            list.insert(i);
        }
        assertTrue(list.search(1));
    }

    @Test
    public void testSearchMultipleElementsListLastElement() {
        
        for (int i = 1; i <= 10; i++) {
            list.insert(i);
        }
        assertTrue(list.search(10));
    }

    @Test
    public void testSearchMultipleElementsListNotFound() {
        
        for (int i = 1; i <= 10; i++) {
            list.insert(i);
        }
        assertFalse(list.search(15));
    }

    @Test
    public void testSearchNegativeValues() {
        
        list.insert(-5);
        list.insert(-10);
        list.insert(5);
        assertTrue(list.search(-10));
        assertFalse(list.search(-3));
    }

    @Test
    public void testSearchZeroValue() {
        list.insert(0);
        assertTrue(list.search(0));
    }
}
