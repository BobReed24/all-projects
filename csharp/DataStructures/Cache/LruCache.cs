using System;
using System.Collections.Generic;

namespace DataStructures.Cache;

public class LruCache<TKey, TValue> where TKey : notnull
{
    private class CachedItem
    {
        public TKey Key { get; set; } = default!;

        public TValue? Value { get; set; }
    }

    private const int DefaultCapacity = 100;

    private readonly int capacity;

    private readonly Dictionary<TKey, LinkedListNode<CachedItem>> cache = new();
    private readonly LinkedList<CachedItem> lruList = new();

    public LruCache(int capacity = DefaultCapacity)
    {
        this.capacity = capacity;
    }

    public bool Contains(TKey key) => cache.ContainsKey(key);

    public TValue? Get(TKey key)
    {
        if (!cache.ContainsKey(key))
        {
            return default;
        }

        var node = cache[key];
        lruList.Remove(node);
        lruList.AddLast(node);

        return node.Value.Value;
    }

    public void Put(TKey key, TValue value)
    {
        if (cache.ContainsKey(key))
        {
            var existingNode = cache[key];
            existingNode.Value.Value = value;
            lruList.Remove(existingNode);
            lruList.AddLast(existingNode);
            return;
        }

        if (cache.Count >= capacity)
        {
            var first = lruList.First!;
            lruList.RemoveFirst();
            cache.Remove(first.Value.Key);
        }

        var item = new CachedItem { Key = key, Value = value };
        var newNode = lruList.AddLast(item);
        cache.Add(key, newNode);
    }
}
