using System.Collections.Generic;

namespace DataStructures.UnrolledList;

public class UnrolledLinkedList
{
    private readonly int sizeNode;

    private UnrolledLinkedListNode start = null!;
    private UnrolledLinkedListNode end = null!;

    public UnrolledLinkedList(int chunkSize)
    {
        sizeNode = chunkSize + 1;
    }

    public void Insert(int value)
    {
        if (start == null)
        {
            start = new UnrolledLinkedListNode(sizeNode);
            start.Set(0, value);

            end = start;
            return;
        }

        if (end.Count + 1 < sizeNode)
        {
            end.Set(end.Count, value);
        }
        else
        {
            var pointer = new UnrolledLinkedListNode(sizeNode);
            var j = 0;
            for (var pos = end.Count / 2 + 1; pos < end.Count; pos++)
            {
                pointer.Set(j++, end.Get(pos));
            }

            pointer.Set(j++, value);
            pointer.Count = j;

            end.Count = end.Count / 2 + 1;
            end.Next = pointer;
            end = pointer;
        }
    }

    public IEnumerable<int> GetRolledItems()
    {
        UnrolledLinkedListNode pointer = start;
        List<int> result = new();

        while (pointer != null)
        {
            for (var i = 0; i < pointer.Count; i++)
            {
                result.Add(pointer.Get(i));
            }

            pointer = pointer.Next;
        }

        return result;
    }
}
