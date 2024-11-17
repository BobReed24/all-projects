package com.thealgorithms.others;

public class LinearCongruentialGenerator {

    private final double a;
    private final double c;
    private final double m;
    private double previousValue;

    public LinearCongruentialGenerator(double multiplier, double increment, double modulo) {
        this(System.currentTimeMillis(), multiplier, increment, modulo);
    }

    public LinearCongruentialGenerator(double seed, double multiplier, double increment, double modulo) {
        this.previousValue = seed;
        this.a = multiplier;
        this.c = increment;
        this.m = modulo;
    }

    public double nextNumber() {
        previousValue = (a * previousValue + c) % m;
        return previousValue;
    }

    public static void main(String[] args) {
        
        LinearCongruentialGenerator lcg = new LinearCongruentialGenerator(1664525, 1013904223, Math.pow(2.0, 32.0));
        for (int i = 0; i < 512; i++) {
            System.out.println(lcg.nextNumber());
        }
    }
}
