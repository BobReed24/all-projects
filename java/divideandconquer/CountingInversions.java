package com.thealgorithms.divideandconquer;

public final class CountingInversions {
    private CountingInversions() {
    }

    public static int countInversions(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    private static int mergeSortAndCount(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int inversions = 0;

        inversions += mergeSortAndCount(arr, left, mid);
        inversions += mergeSortAndCount(arr, mid + 1, right);
        inversions += mergeAndCount(arr, left, mid, right);
        return inversions;
    }

    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        System.arraycopy(arr, left, leftArr, 0, mid - left + 1);
        System.arraycopy(arr, mid + 1, rightArr, 0, right - mid);

        int i = 0;
        int j = 0;
        int k = left;
        int inversions = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                inversions += mid + 1 - left - i;
            }
        }

        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }

        return inversions;
    }
}
