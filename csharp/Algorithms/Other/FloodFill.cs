using System;
using System.Collections.Generic;
using SkiaSharp;

namespace Algorithms.Other;

public static class FloodFill
{
    private static readonly List<(int XOffset, int YOffset)> Neighbors = new() { (-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1) };

    public static void BreadthFirstSearch(SKBitmap bitmap, (int X, int Y) location, SKColor targetColor, SKColor replacementColor)
    {
        if (location.X < 0 || location.X >= bitmap.Width || location.Y < 0 || location.Y >= bitmap.Height)
        {
            throw new ArgumentOutOfRangeException(nameof(location), $"{nameof(location)} should point to a pixel within the bitmap");
        }

        var queue = new List<(int X, int Y)>();
        queue.Add(location);

        while (queue.Count > 0)
        {
            BreadthFirstFill(bitmap, location, targetColor, replacementColor, queue);
        }
    }

    public static void DepthFirstSearch(SKBitmap bitmap, (int X, int Y) location, SKColor targetColor, SKColor replacementColor)
    {
        if (location.X < 0 || location.X >= bitmap.Width || location.Y < 0 || location.Y >= bitmap.Height)
        {
            throw new ArgumentOutOfRangeException(nameof(location), $"{nameof(location)} should point to a pixel within the bitmap");
        }

        DepthFirstFill(bitmap, location, targetColor, replacementColor);
    }

    private static void BreadthFirstFill(SKBitmap bitmap, (int X, int Y) location, SKColor targetColor, SKColor replacementColor, List<(int X, int Y)> queue)
    {
        (int X, int Y) currentLocation = queue[0];
        queue.RemoveAt(0);

        if (bitmap.GetPixel(currentLocation.X, currentLocation.Y) == targetColor)
        {
            bitmap.SetPixel(currentLocation.X, currentLocation.Y, replacementColor);

            for (int i = 0; i < Neighbors.Count; i++)
            {
                int x = currentLocation.X + Neighbors[i].XOffset;
                int y = currentLocation.Y + Neighbors[i].YOffset;
                if (x >= 0 && x < bitmap.Width && y >= 0 && y < bitmap.Height)
                {
                    queue.Add((x, y));
                }
            }
        }
    }

    private static void DepthFirstFill(SKBitmap bitmap, (int X, int Y) location, SKColor targetColor, SKColor replacementColor)
    {
        if (bitmap.GetPixel(location.X, location.Y) == targetColor)
        {
            bitmap.SetPixel(location.X, location.Y, replacementColor);

            for (int i = 0; i < Neighbors.Count; i++)
            {
                int x = location.X + Neighbors[i].XOffset;
                int y = location.Y + Neighbors[i].YOffset;
                if (x >= 0 && x < bitmap.Width && y >= 0 && y < bitmap.Height)
                {
                    DepthFirstFill(bitmap, (x, y), targetColor, replacementColor);
                }
            }
        }
    }
}
