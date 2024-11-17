namespace Algorithms.Shufflers;

public interface IShuffler<in T>
{
    
    void Shuffle(T[] array, int? seed = null);
}
