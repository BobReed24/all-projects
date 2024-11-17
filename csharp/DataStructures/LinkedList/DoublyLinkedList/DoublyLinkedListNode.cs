namespace DataStructures.LinkedList.DoublyLinkedList;

public class DoublyLinkedListNode<T>
{
    
    public DoublyLinkedListNode(T data) => Data = data;

    public T Data { get; }

    public DoublyLinkedListNode<T>? Next { get; set; }

    public DoublyLinkedListNode<T>? Previous { get; set; }
}
