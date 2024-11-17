package com.thealgorithms.maths;

public class Armstrong {

    public boolean isArmstrong(int number) {
        long sum = 0;
        String temp = Integer.toString(number); 
        int power = temp.length(); 
        long originalNumber = number;

        while (originalNumber > 0) {
            long digit = originalNumber % 10;
            sum += (long) Math.pow(digit, power); 
            originalNumber /= 10;
        }

        return sum == number;
    }
}
