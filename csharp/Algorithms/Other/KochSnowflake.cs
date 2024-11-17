using System;
using System.Collections.Generic;
using System.Numerics;
using SkiaSharp;

namespace Algorithms.Other;

public static class KochSnowflake
{
    
    public static List<Vector2> Iterate(List<Vector2> initialVectors, int steps = 5)
    {
        List<Vector2> vectors = initialVectors;
        for (var i = 0; i < steps; i++)
        {
            vectors = IterationStep(vectors);
        }

        return vectors;
    }

    public static SKBitmap GetKochSnowflake(
        int bitmapWidth = 600,
        int steps = 5)
    {
        if (bitmapWidth <= 0)
        {
            throw new ArgumentOutOfRangeException(
                nameof(bitmapWidth),
                $"{nameof(bitmapWidth)} should be greater than zero");
        }

        var offsetX = bitmapWidth / 10f;
        var offsetY = bitmapWidth / 3.7f;
        var vector1 = new Vector2(offsetX, offsetY);
        var vector2 = new Vector2(bitmapWidth / 2, (float)Math.Sin(Math.PI / 3) * bitmapWidth * 0.8f + offsetY);
        var vector3 = new Vector2(bitmapWidth - offsetX, offsetY);
        List<Vector2> initialVectors = new() { vector1, vector2, vector3, vector1 };
        List<Vector2> vectors = Iterate(initialVectors, steps);
        return GetBitmap(vectors, bitmapWidth, bitmapWidth);
    }

    private static List<Vector2> IterationStep(List<Vector2> vectors)
    {
        List<Vector2> newVectors = new();
        for (var i = 0; i < vectors.Count - 1; i++)
        {
            var startVector = vectors[i];
            var endVector = vectors[i + 1];
            newVectors.Add(startVector);
            var differenceVector = endVector - startVector;
            newVectors.Add(startVector + differenceVector / 3);
            newVectors.Add(startVector + differenceVector / 3 + Rotate(differenceVector / 3, 60));
            newVectors.Add(startVector + differenceVector * 2 / 3);
        }

        newVectors.Add(vectors[^1]);
        return newVectors;
    }

    private static Vector2 Rotate(Vector2 vector, float angleInDegrees)
    {
        var radians = angleInDegrees * (float)Math.PI / 180;
        var ca = (float)Math.Cos(radians);
        var sa = (float)Math.Sin(radians);
        return new Vector2(ca * vector.X - sa * vector.Y, sa * vector.X + ca * vector.Y);
    }

    private static SKBitmap GetBitmap(
        List<Vector2> vectors,
        int bitmapWidth,
        int bitmapHeight)
    {
        SKBitmap bitmap = new(bitmapWidth, bitmapHeight);
        var canvas = new SKCanvas(bitmap);

        var rect = SKRect.Create(0, 0, bitmapWidth, bitmapHeight);

        var paint = new SKPaint
        {
            Style = SKPaintStyle.Fill,
            Color = SKColors.White,
        };

        canvas.DrawRect(rect, paint);

        paint.Color = SKColors.Black;

        for (var i = 0; i < vectors.Count - 1; i++)
        {
            var x1 = vectors[i].X;
            var y1 = vectors[i].Y;
            var x2 = vectors[i + 1].X;
            var y2 = vectors[i + 1].Y;

            canvas.DrawLine(new SKPoint(x1, y1), new SKPoint(x2, y2), paint);
        }

        return bitmap;
    }
}
