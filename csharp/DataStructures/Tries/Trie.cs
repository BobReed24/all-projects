using System;
using System.Collections.Generic;

namespace DataStructures.Tries;

public class Trie
{
    
    private const char Mark = '$';

    private readonly TrieNode root;

    public Trie()
    {
        root = new TrieNode(Mark);
    }

    public Trie(IEnumerable<string> words)
        : this()
    {
        foreach (string s in words)
        {
            Insert(s);
        }
    }

    public void Insert(string s)
    {
        s += Mark;

        int index = 0;
        TrieNode match = PrefixQuery(s, ref index);

        for (int i = index; i < s.Length; i++)
        {
            TrieNode t = new(s[i], match);
            match[s[i]] = t;
            match = t;
        }
    }

    public void Remove(string s)
    {
        s += Mark;
        int index = 0;
        TrieNode match = PrefixQuery(s, ref index);
        while(match.IsLeaf())
        {
            char c = match.Value;
            if(match.Parent == null)
            {
                break;
            }

            match = match.Parent;
            match.Children.Remove(c);
        }
    }

    public bool Find(string s)
    {
        int index = 0;
        return PrefixQuery(s + Mark, ref index).IsLeaf();
    }

    private TrieNode PrefixQuery(string s, ref int index)
    {
        TrieNode current = root;
        for (int i = 0; i < s.Length && current != null; i++)
        {
            if (current[s[i]] != null)
            {
                current = current[s[i]] ?? throw new NullReferenceException();
                index = i + 1;
            }
            else
            {
                break;
            }
        }

        return current ?? throw new NullReferenceException();
    }
}
