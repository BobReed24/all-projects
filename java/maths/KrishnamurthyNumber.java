package com.thealgorithms.maths;

public final class KrishnamurthyNumber {

    private KrishnamurthyNumber() {
    }

    public static boolean isKrishnamurthy(int n) {
        int tmp = n;
        int s = 0;

        if (n <= 0) {
            return false;
        } else {
            while (n != 0) {
                
                int fact = 1;
                
                for (int i = 1; i <= n % 10; i++) {
                    fact = fact * i;
                }
                
                s = s + fact;
                
                n = n / 10;
            }

            return tmp == s;
        }
    }
}
