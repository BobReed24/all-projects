using System;
using System.Collections.Generic;

namespace DataStructures.LinkedList.SinglyLinkedList;

public class SinglyLinkedList<T>
{
    
    private SinglyLinkedListNode<T>? Head { get; set; }

    public SinglyLinkedListNode<T> AddFirst(T data)
    {
        var newListElement = new SinglyLinkedListNode<T>(data)
        {
            Next = Head,
        };

        Head = newListElement;
        return newListElement;
    }

    public SinglyLinkedListNode<T> AddLast(T data)
    {
        var newListElement = new SinglyLinkedListNode<T>(data);

        if (Head is null)
        {
            Head = newListElement;
            return newListElement;
        }

        var tempElement = Head;

        while (tempElement.Next is not null)
        {
            tempElement = tempElement.Next;
        }

        tempElement.Next = newListElement;
        return newListElement;
    }

    public T GetElementByIndex(int index)
    {
        if (index < 0)
        {
            throw new ArgumentOutOfRangeException(nameof(index));
        }

        var tempElement = Head;

        for (var i = 0; tempElement is not null && i < index; i++)
        {
            tempElement = tempElement.Next;
        }

        if (tempElement is null)
        {
            throw new ArgumentOutOfRangeException(nameof(index));
        }

        return tempElement.Data;
    }

    public int Length()
    {
        
        if (Head is null)
        {
            return 0;
        }

        var tempElement = Head;
        var length = 1;

        while (tempElement.Next is not null)
        {
            tempElement = tempElement.Next;
            length++;
        }

        return length;
    }

    public IEnumerable<T> GetListData()
    {
        
        var tempElement = Head;

        while (tempElement is not null)
        {
            yield return tempElement.Data;
            tempElement = tempElement.Next;
        }
    }

    public bool DeleteElement(T element)
    {
        var currentElement = Head;
        SinglyLinkedListNode<T>? previousElement = null;

        while (currentElement is not null)
        {
            
            if (currentElement.Data is null && element is null ||
                currentElement.Data is not null && currentElement.Data.Equals(element))
            {
                
                if (currentElement.Equals(Head))
                {
                    Head = Head.Next;
                    return true;
                }

                if (previousElement is not null)
                {
                    previousElement.Next = currentElement.Next;
                    return true;
                }
            }

            previousElement = currentElement;
            currentElement = currentElement.Next;
        }

        return false;
    }

    public bool DeleteFirst()
    {
        
        if(Head is null)
        {
            return false;
        }

        Head = Head.Next;
        return true;
    }

    public bool DeleteLast()
    {
        
        if(Head is null)
        {
            return false;
        }

        if(Head.Next is null)
        {
            Head = null;
            return true;
        }

        SinglyLinkedListNode<T>? secondlast = Head;
        while(secondlast.Next?.Next is not null)
        {
            secondlast = secondlast.Next;
        }

        secondlast.Next = null;
        return true;
    }
}
