package com.thealgorithms.misc;

import java.util.Random;

public final class ShuffleArray {
    
    private ShuffleArray() {
    }

    public static void shuffle(int[] arr) {
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
