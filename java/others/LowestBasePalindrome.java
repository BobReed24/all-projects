package com.thealgorithms.others;

import java.util.ArrayList;
import java.util.List;

public final class LowestBasePalindrome {
    private LowestBasePalindrome() {
    }

    private static void checkBase(int base) {
        if (base <= 1) {
            throw new IllegalArgumentException("Base must be greater than 1.");
        }
    }

    private static void checkNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
    }

    public static List<Integer> computeDigitsInBase(int number, int base) {
        checkNumber(number);
        checkBase(base);

        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % base);
            number /= base;
        }
        return digits;
    }

    public static boolean isPalindromic(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            if (!list.get(i).equals(list.get(size - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromicInBase(int number, int base) {
        checkNumber(number);
        checkBase(base);

        if (number <= 1) {
            return true;
        }

        if (number % base == 0) {
            
            return false;
        }

        return isPalindromic(computeDigitsInBase(number, base));
    }

    public static int lowestBasePalindrome(int number) {
        checkNumber(number);

        int base = 2;
        while (!isPalindromicInBase(number, base)) {
            base++;
        }
        return base;
    }
}
