namespace Algorithms.Encoders;

public interface IEncoder<TKey>
{
    
    string Encode(string text, TKey key);

    string Decode(string text, TKey key);
}
