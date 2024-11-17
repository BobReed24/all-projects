package com.thealgorithms.conversions;

public final class AffineConverter {
    private final double slope;
    private final double intercept;

    public AffineConverter(final double inSlope, final double inIntercept) {
        if (Double.isNaN(inSlope) || Double.isNaN(inIntercept)) {
            throw new IllegalArgumentException("Slope and intercept must be valid numbers.");
        }
        slope = inSlope;
        intercept = inIntercept;
    }

    public double convert(final double inValue) {
        return slope * inValue + intercept;
    }

    public AffineConverter invert() {
        assert slope != 0.0 : "Slope cannot be zero for inversion.";
        return new AffineConverter(1.0 / slope, -intercept / slope);
    }

    public AffineConverter compose(final AffineConverter other) {
        double newSlope = slope * other.slope;
        double newIntercept = slope * other.intercept + intercept;
        return new AffineConverter(newSlope, newIntercept);
    }
}
