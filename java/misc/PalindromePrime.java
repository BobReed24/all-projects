package com.thealgorithms.misc;

import java.util.ArrayList;
import java.util.List;

public final class PalindromePrime {
    private PalindromePrime() {
    }

    public static boolean prime(int num) {
        if (num < 2) {
            return false; 
        }
        if (num == 2) {
            return true; 
        }
        if (num % 2 == 0) {
            return false; 
        }

        for (int divisor = 3; divisor <= Math.sqrt(num); divisor += 2) {
            if (num % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static int reverse(int n) {
        int reverse = 0;
        while (n != 0) {
            reverse = reverse * 10 + (n % 10);
            n /= 10;
        }
        return reverse;
    }

    public static List<Integer> generatePalindromePrimes(int n) {
        List<Integer> palindromicPrimes = new ArrayList<>();
        if (n <= 0) {
            return palindromicPrimes; 
        }

        palindromicPrimes.add(2); 
        int count = 1;
        int num = 3;

        while (count < n) {
            if (num == reverse(num) && prime(num)) {
                palindromicPrimes.add(num);
                count++;
            }
            num += 2; 
        }
        return palindromicPrimes;
    }
}
