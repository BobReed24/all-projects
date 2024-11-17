using System;
using System.Collections.Generic;

namespace DataStructures.Cache;

public class LfuCache<TKey, TValue> where TKey : notnull
{
    private class CachedItem
    {
        public TKey Key { get; set; } = default!;

        public TValue? Value { get; set; }

        public int Frequency { get; set; }
    }

    private const int DefaultCapacity = 100;

    private readonly int capacity;

    private readonly Dictionary<TKey, LinkedListNode<CachedItem>> cache = new();

    private readonly Dictionary<int, LinkedList<CachedItem>> frequencies = new();

    private int minFrequency = -1;

    public LfuCache(int capacity = DefaultCapacity)
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
        UpdateFrequency(node, isNew: false);
        return node.Value.Value;
    }

    public void Put(TKey key, TValue value)
    {
        if (cache.ContainsKey(key))
        {
            var existingNode = cache[key];
            existingNode.Value.Value = value;
            UpdateFrequency(existingNode, isNew: false);
            return;
        }

        if (cache.Count >= capacity)
        {
            EvictOneItem();
        }

        var item = new CachedItem { Key = key, Value = value };
        var newNode = new LinkedListNode<CachedItem>(item);
        UpdateFrequency(newNode, isNew: true);
        cache.Add(key, newNode);
    }

    private void UpdateFrequency(LinkedListNode<CachedItem> node, bool isNew)
    {
        var item = node.Value;

        if (isNew)
        {
            item.Frequency = 1;
            minFrequency = 1;
        }
        else
        {
            
            var lruList = frequencies[item.Frequency];
            lruList.Remove(node);
            if (lruList.Count == 0 && minFrequency == item.Frequency)
            {
                minFrequency++;
            }

            item.Frequency++;
        }

        if (!frequencies.ContainsKey(item.Frequency))
        {
            frequencies[item.Frequency] = new LinkedList<CachedItem>();
        }

        frequencies[item.Frequency].AddLast(node);
    }

    private void EvictOneItem()
    {
        var lruList = frequencies[minFrequency];
        var itemToRemove = lruList.First!.Value;
        lruList.RemoveFirst();
        cache.Remove(itemToRemove.Key);
    }
}
