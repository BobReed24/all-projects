package com.thealgorithms.searches;

import java.util.Scanner;

abstract class SearchAlgorithm<T extends Comparable<T>> {
    
    public abstract int find(T[] arr, T target);
}

public class RecursiveBinarySearch<T extends Comparable<T>> extends SearchAlgorithm<T> {

    @Override
    public int find(T[] arr, T target) {
        
        return binsear(arr, 0, arr.length - 1, target);
    }

    public int binsear(T[] arr, int left, int right, T target) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            int comparison = arr[mid].compareTo(target);

            if (comparison == 0) {
                return mid;
            }

            if (comparison > 0) {
                return binsear(arr, left, mid - 1, target);
            }

            return binsear(arr, mid + 1, right, target);
        }

        return -1;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            
            System.out.print("Enter the number of elements in the array: ");
            int n = sc.nextInt();

            Integer[] a = new Integer[n]; 

            System.out.println("Enter the elements in sorted order:");

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            System.out.print("Enter the target element to search for: ");
            int t = sc.nextInt();

            RecursiveBinarySearch<Integer> searcher = new RecursiveBinarySearch<>();
            int res = searcher.find(a, t);

            if (res == -1) {
                System.out.println("Element not found in the array.");
            } else {
                System.out.println("Element found at index " + res);
            }
        }
    }
}
