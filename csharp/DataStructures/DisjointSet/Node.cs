namespace DataStructures.DisjointSet;

public class Node<T>
{
    public int Rank { get; set; }

    public Node<T> Parent { get; set; }

    public T Data { get; set; }

    public Node(T data)
    {
        Data = data;
        Parent = this;
    }
}
