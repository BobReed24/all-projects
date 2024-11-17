package com.thealgorithms.misc;

import java.awt.Color;

public class ColorContrastRatio {

    public double getContrastRatio(Color a, Color b) {
        final double aColorLuminance = getRelativeLuminance(a);
        final double bColorLuminance = getRelativeLuminance(b);

        if (aColorLuminance > bColorLuminance) {
            return (aColorLuminance + 0.05) / (bColorLuminance + 0.05);
        }

        return (bColorLuminance + 0.05) / (aColorLuminance + 0.05);
    }

    public double getRelativeLuminance(Color color) {
        final double red = getColor(color.getRed());
        final double green = getColor(color.getGreen());
        final double blue = getColor(color.getBlue());

        return 0.2126 * red + 0.7152 * green + 0.0722 * blue;
    }

    public double getColor(int color8Bit) {
        final double sRgb = getColorSRgb(color8Bit);
        return (sRgb <= 0.03928) ? sRgb / 12.92 : Math.pow((sRgb + 0.055) / 1.055, 2.4);
    }

    private double getColorSRgb(double color8Bit) {
        return color8Bit / 255.0;
    }
}
