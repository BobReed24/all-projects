package com.thealgorithms.searches;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class BinarySearch2dArrayTest {

    @Test
    
    public void binarySearch2dArrayTestMiddle() {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int target = 6;

        int[] ans = BinarySearch2dArray.binarySearch(arr, target);
        System.out.println(Arrays.toString(ans));
        assertEquals(1, ans[0]);
        assertEquals(1, ans[1]);
    }

    @Test
    
    public void binarySearch2dArrayTestMiddleSide() {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int target = 8;

        int[] ans = BinarySearch2dArray.binarySearch(arr, target);
        System.out.println(Arrays.toString(ans));
        assertEquals(1, ans[0]);
        assertEquals(3, ans[1]);
    }

    @Test
    
    public void binarySearch2dArrayTestUpper() {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int target = 2;

        int[] ans = BinarySearch2dArray.binarySearch(arr, target);
        System.out.println(Arrays.toString(ans));
        assertEquals(0, ans[0]);
        assertEquals(1, ans[1]);
    }

    @Test
    
    public void binarySearch2dArrayTestUpperSide() {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int target = 1;

        int[] ans = BinarySearch2dArray.binarySearch(arr, target);
        System.out.println(Arrays.toString(ans));
        assertEquals(0, ans[0]);
        assertEquals(0, ans[1]);
    }

    @Test
    
    public void binarySearch2dArrayTestLower() {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int target = 10;

        int[] ans = BinarySearch2dArray.binarySearch(arr, target);
        System.out.println(Arrays.toString(ans));
        assertEquals(2, ans[0]);
        assertEquals(1, ans[1]);
    }

    @Test
    
    public void binarySearch2dArrayTestLowerSide() {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int target = 11;

        int[] ans = BinarySearch2dArray.binarySearch(arr, target);
        System.out.println(Arrays.toString(ans));
        assertEquals(2, ans[0]);
        assertEquals(2, ans[1]);
    }

    @Test
    
    public void binarySearch2dArrayTestNotFound() {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int target = 101;

        int[] ans = BinarySearch2dArray.binarySearch(arr, target);
        System.out.println(Arrays.toString(ans));
        assertEquals(-1, ans[0]);
        assertEquals(-1, ans[1]);
    }

    @Test
    public void binarySearch2dArrayTestOneRow() {
        int[][] arr = {{1, 2, 3, 4}};
        int target = 2;

        assertEquals(arr.length, 1);
        int[] ans = BinarySearch2dArray.binarySearch(arr, target);
        System.out.println(Arrays.toString(ans));
        assertEquals(0, ans[0]);
        assertEquals(1, ans[1]);
    }

    @Test
    public void binarySearch2dArrayTestTargetInMiddle() {
        int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        int target = 8;
        
        assertEquals(arr[arr.length / 2][arr[0].length / 2], target);
        int[] ans = BinarySearch2dArray.binarySearch(arr, target);
        System.out.println(Arrays.toString(ans));
        assertEquals(1, ans[0]);
        assertEquals(2, ans[1]);
    }

    @Test
    public void binarySearch2dArrayTestTargetAboveMiddleRowInMiddleColumn() {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int target = 3;

        assertEquals(arr[0].length % 2, 0);
        assertEquals(arr[arr.length / 2 - 1][arr[0].length / 2], target);
        int[] ans = BinarySearch2dArray.binarySearch(arr, target);
        System.out.println(Arrays.toString(ans));
        assertEquals(0, ans[0]);
        assertEquals(2, ans[1]);
    }

    @Test
    public void binarySearch2dArrayTestEmptyArray() {
        int[][] arr = {};
        int target = 5;

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> BinarySearch2dArray.binarySearch(arr, target));
    }
}
