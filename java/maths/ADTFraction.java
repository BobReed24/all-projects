package com.thealgorithms.maths;

public record ADTFraction(int numerator, int denominator) {
    
    public ADTFraction {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be 0");
        }
    }

    public ADTFraction plus(ADTFraction fraction) {
        var numerator = this.denominator * fraction.numerator + this.numerator * fraction.denominator;
        var denominator = this.denominator * fraction.denominator;
        return new ADTFraction(numerator, denominator);
    }

    public ADTFraction times(int number) {
        return times(new ADTFraction(number, 1));
    }

    public ADTFraction times(ADTFraction fraction) {
        var numerator = this.numerator * fraction.numerator;
        var denominator = this.denominator * fraction.denominator;
        return new ADTFraction(numerator, denominator);
    }

    public ADTFraction reciprocal() {
        return new ADTFraction(this.denominator, this.numerator);
    }

    public float value() {
        return (float) this.numerator / this.denominator;
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.numerator, this.denominator);
    }
}
