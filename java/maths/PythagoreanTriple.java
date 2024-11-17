package com.thealgorithms.maths;

public final class PythagoreanTriple {
    private PythagoreanTriple() {
    }

    public static void main(String[] args) {
        assert isPythagTriple(3, 4, 5);
        assert isPythagTriple(5, 12, 13);
        assert isPythagTriple(6, 8, 10);
        assert !isPythagTriple(10, 20, 30);
        assert !isPythagTriple(6, 8, 100);
        assert !isPythagTriple(-1, -1, 1);
    }

    public static boolean isPythagTriple(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        } else {
            return (a * a) + (b * b) == (c * c);
        }
    }
}
