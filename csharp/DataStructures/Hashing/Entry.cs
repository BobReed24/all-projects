using System;
using System.Collections.Generic;
using System.Linq;
using DataStructures.Hashing.NumberTheory;

namespace DataStructures.Hashing;

public class Entry<TKey, TValue>
{
    public TKey? Key { get; set; }

    public TValue? Value { get; set; }

    public Entry(TKey key, TValue value)
    {
        Key = key;
        Value = value;
    }
}
