package com.thealgorithms.audiofilters;

public class EMAFilter {
    private final double alpha;
    private double emaValue;
    
    public EMAFilter(double alpha) {
        if (alpha <= 0 || alpha > 1) {
            throw new IllegalArgumentException("Alpha must be between 0 and 1.");
        }
        this.alpha = alpha;
        this.emaValue = 0.0;
    }
    
    public double[] apply(double[] audioSignal) {
        if (audioSignal.length == 0) {
            return new double[0];
        }
        double[] emaSignal = new double[audioSignal.length];
        emaValue = audioSignal[0];
        emaSignal[0] = emaValue;
        for (int i = 1; i < audioSignal.length; i++) {
            emaValue = alpha * audioSignal[i] + (1 - alpha) * emaValue;
            emaSignal[i] = emaValue;
        }
        return emaSignal;
    }
}
