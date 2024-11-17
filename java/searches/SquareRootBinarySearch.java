package com.thealgorithms.searches;

public final class SquareRootBinarySearch {
    private SquareRootBinarySearch() {
    }

    static long squareRoot(long num) {
        if (num == 0 || num == 1) {
            return num;
        }
        long l = 1;
        long r = num;
        long ans = 0;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid == num / mid) {
                return mid;
            } else if (mid < num / mid) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
