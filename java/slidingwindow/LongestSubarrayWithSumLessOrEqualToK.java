package com.thealgorithms.slidingwindow;

public final class LongestSubarrayWithSumLessOrEqualToK {

    private LongestSubarrayWithSumLessOrEqualToK() {
    }

    public static int longestSubarrayWithSumLEK(int[] arr, int k) {
        int maxLength = 0; 
        int currentSum = 0; 
        int left = 0; 

        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right]; 

            while (currentSum > k && left <= right) {
                currentSum -= arr[left]; 
                left++; 
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength; 
    }
}
