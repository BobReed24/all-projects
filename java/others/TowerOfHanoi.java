package com.thealgorithms.others;

import java.util.List;

final class TowerOfHanoi {

    private TowerOfHanoi() {
    }

    public static void shift(int n, String startPole, String intermediatePole, String endPole, List<String> result) {
        if (n != 0) {
            
            shift(n - 1, startPole, endPole, intermediatePole, result);

            result.add(String.format("Move %d from %s to %s", n, startPole, endPole));

            shift(n - 1, intermediatePole, startPole, endPole, result);
        }
    }
}
