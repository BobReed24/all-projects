namespace DataStructures.LinkedList.CircularLinkedList
{
    
    public class CircularLinkedListNode<T>(T data)
    {
        
        public T Data { get; set; } = data;

        public CircularLinkedListNode<T>? Next { get; set; }
    }
}
