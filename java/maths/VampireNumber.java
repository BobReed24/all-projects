package com.thealgorithms.maths;

import java.util.ArrayList;
import java.util.Collections;

public final class VampireNumber {
    private VampireNumber() {
    }

    public static void main(String[] args) {
        test(10, 1000);
    }

    static void test(int startValue, int stopValue) {
        int countofRes = 1;
        StringBuilder res = new StringBuilder();

        for (int i = startValue; i <= stopValue; i++) {
            for (int j = i; j <= stopValue; j++) {
                
                if (isVampireNumber(i, j, true)) {
                    countofRes++;
                    res.append("").append(countofRes).append(": = ( ").append(i).append(",").append(j).append(" = ").append(i * j).append(")").append("\n");
                }
            }
        }
        System.out.println(res);
    }

    static boolean isVampireNumber(int a, int b, boolean noPseudoVamireNumbers) {
        
        if (noPseudoVamireNumbers) {
            if (a * 10 <= b || b * 10 <= a) {
                return false;
            }
        }

        String mulDigits = splitIntoDigits(a * b, 0);
        String faktorDigits = splitIntoDigits(a, b);

        return mulDigits.equals(faktorDigits);
    }

    static String splitIntoDigits(int num, int num2) {
        StringBuilder res = new StringBuilder();

        ArrayList<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        while (num2 > 0) {
            digits.add(num2 % 10);
            num2 /= 10;
        }
        Collections.sort(digits);
        for (int i : digits) {
            res.append(i);
        }

        return res.toString();
    }
}
