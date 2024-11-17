using System;
using SkiaSharp;

namespace Algorithms.Other;

public static class Mandelbrot
{
    private const byte Alpha = 255;

    public static SKBitmap GetBitmap(
        int bitmapWidth = 800,
        int bitmapHeight = 600,
        double figureCenterX = -0.6,
        double figureCenterY = 0,
        double figureWidth = 3.2,
        int maxStep = 50,
        bool useDistanceColorCoding = true)
    {
        if (bitmapWidth <= 0)
        {
            throw new ArgumentOutOfRangeException(
                nameof(bitmapWidth),
                $"{nameof(bitmapWidth)} should be greater than zero");
        }

        if (bitmapHeight <= 0)
        {
            throw new ArgumentOutOfRangeException(
                nameof(bitmapHeight),
                $"{nameof(bitmapHeight)} should be greater than zero");
        }

        if (maxStep <= 0)
        {
            throw new ArgumentOutOfRangeException(
                nameof(maxStep),
                $"{nameof(maxStep)} should be greater than zero");
        }

        var bitmap = new SKBitmap(bitmapWidth, bitmapHeight);
        var figureHeight = figureWidth / bitmapWidth * bitmapHeight;

        for (var bitmapX = 0; bitmapX < bitmapWidth; bitmapX++)
        {
            for (var bitmapY = 0; bitmapY < bitmapHeight; bitmapY++)
            {
                
                var figureX = figureCenterX + ((double)bitmapX / bitmapWidth - 0.5) * figureWidth;
                var figureY = figureCenterY + ((double)bitmapY / bitmapHeight - 0.5) * figureHeight;

                var distance = GetDistance(figureX, figureY, maxStep);

                bitmap.SetPixel(
                    bitmapX,
                    bitmapY,
                    useDistanceColorCoding ? ColorCodedColorMap(distance) : BlackAndWhiteColorMap(distance));
            }
        }

        return bitmap;
    }

    private static SKColor BlackAndWhiteColorMap(double distance) =>
        distance >= 1
            ? new SKColor(0, 0, 0, Alpha)
            : new SKColor(255, 255, 255, Alpha);

    private static SKColor ColorCodedColorMap(double distance)
    {
        if (distance >= 1)
        {
            return new SKColor(0, 0, 0, Alpha);
        }

        var hue = 360 * distance;
        double saturation = 1;
        double val = 255;
        var hi = (int)Math.Floor(hue / 60) % 6;
        var f = hue / 60 - Math.Floor(hue / 60);

        var v = (byte)val;
        const byte p = 0;
        var q = (byte)(val * (1 - f * saturation));
        var t = (byte)(val * (1 - (1 - f) * saturation));

        switch (hi)
        {
            case 0: return new SKColor(v, t, p, Alpha);
            case 1: return new SKColor(q, v, p, Alpha);
            case 2: return new SKColor(p, v, t, Alpha);
            case 3: return new SKColor(p, q, v, Alpha);
            case 4: return new SKColor(t, p, v, Alpha);
            default: return new SKColor(v, p, q, Alpha);
        }
    }

    private static double GetDistance(double figureX, double figureY, int maxStep)
    {
        var a = figureX;
        var b = figureY;
        var currentStep = 0;
        for (var step = 0; step < maxStep; step++)
        {
            currentStep = step;
            var aNew = a * a - b * b + figureX;
            b = 2 * a * b + figureY;
            a = aNew;

            if (a * a + b * b > 4)
            {
                break;
            }
        }

        return (double)currentStep / (maxStep - 1);
    }
}
