using System.Text;

namespace Algorithms.Encoders;

public class CaesarEncoder : IEncoder<int>
{
    
    public string Encode(string text, int key) => Cipher(text, key);

    public string Decode(string text, int key) => Cipher(text, -key);

    private static string Cipher(string text, int key)
    {
        var newText = new StringBuilder(text.Length);
        for (var i = 0; i < text.Length; i++)
        {
            if (!char.IsLetter(text[i]))
            {
                _ = newText.Append(text[i]);
                continue;
            }

            var letterA = char.IsUpper(text[i]) ? 'A' : 'a';
            var letterZ = char.IsUpper(text[i]) ? 'Z' : 'z';

            var c = text[i] + key;
            c -= c > letterZ ? 26 * (1 + (c - letterZ - 1) / 26) : 0;
            c += c < letterA ? 26 * (1 + (letterA - c - 1) / 26) : 0;

            _ = newText.Append((char)c);
        }

        return newText.ToString();
    }
}
