using System;
using System.Collections.Generic;

namespace DataStructures.Probabilistic;

public class BloomFilter<T> where T : notnull
{
    private const uint FnvPrime = 16777619;
    private const uint FnvOffsetBasis = 2166136261;
    private readonly byte[] filter;
    private readonly int numHashes;
    private readonly int sizeBits;

    public BloomFilter(int expectedNumElements)
    {
        numHashes = (int)Math.Ceiling(.693 * 8 * expectedNumElements / expectedNumElements); 
        filter = new byte[expectedNumElements]; 
        sizeBits = expectedNumElements * 8; 
    }

    public BloomFilter(int sizeBits, int numHashes)
    {
        filter = new byte[sizeBits / 8 + 1];
        this.numHashes = numHashes;
        this.sizeBits = sizeBits;
    }

    public void Insert(T item)
    {
        foreach (var slot in GetSlots(item))
        {
            filter[slot / 8] |= (byte)(1 << (slot % 8)); 
        }
    }

    public bool Search(T item)
    {
        foreach (var slot in GetSlots(item))
        {
            var @byte = filter[slot / 8]; 
            var mask = 1 << (slot % 8); 
            if ((@byte & mask) != mask)
            {
                return false;
            }
        }

        return true;
    }

    private IEnumerable<int> GetSlots(T item)
    {
        var hash = item.GetHashCode();
        for (var i = 0; i < numHashes; i++)
        {
            yield return Math.Abs((i + 1) * hash) % sizeBits;
        }
    }
}
