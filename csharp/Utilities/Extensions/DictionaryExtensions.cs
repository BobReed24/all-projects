using System;
using System.Collections.Generic;

namespace Utilities.Extensions;

public static class DictionaryExtensions
{
    
    public static void AddMany<TKey, TValue>(
        this Dictionary<TKey, TValue> keys,
        IEnumerable<(TKey Key, TValue Value)> enumerable) where TKey : notnull
    {
        foreach (var (key, value) in enumerable)
        {
            keys.Add(key, value);
        }
    }
}
