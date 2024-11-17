using System;

namespace DataStructures.Probabilistic;

public class CountMinSketch<T> where T : notnull
{
    private readonly int[][] sketch;
    private readonly int numHashes;

    public CountMinSketch(int width, int numHashes)
    {
        sketch = new int[numHashes][];
        for (var i = 0; i < numHashes; i++)
        {
            sketch[i] = new int[width];
        }

        this.numHashes = numHashes;
    }

    public CountMinSketch(double errorRate, double errorProb)
    {
        var width = (int)Math.Ceiling(Math.E / errorRate);
        numHashes = (int)Math.Ceiling(Math.Log(1.0 / errorProb));
        sketch = new int[numHashes][];
        for (var i = 0; i < numHashes; i++)
        {
            sketch[i] = new int[width];
        }
    }

    public void Insert(T item)
    {
        var initialHash = item.GetHashCode();
        for (int i = 0; i < numHashes; i++)
        {
            var slot = GetSlot(i, initialHash);
            sketch[i][slot]++;
        }
    }

    public int Query(T item)
    {
        var initialHash = item.GetHashCode();
        var min = int.MaxValue;
        for (int i = 0; i < numHashes; i++)
        {
            var slot = GetSlot(i, initialHash);
            min = Math.Min(sketch[i][slot], min);
        }

        return min;
    }

    private int GetSlot(int i, int initialHash) => Math.Abs((i + 1) * initialHash) % sketch[0].Length;
}
