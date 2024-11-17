using System;
using System.Text;

namespace Algorithms.Encoders;

public class VigenereEncoder : IEncoder<string>
{
    private readonly CaesarEncoder caesarEncoder = new();

    public string Encode(string text, string key) => Cipher(text, key, caesarEncoder.Encode);

    public string Decode(string text, string key) => Cipher(text, key, caesarEncoder.Decode);

    private string Cipher(string text, string key, Func<string, int, string> symbolCipher)
    {
        key = AppendKey(key, text.Length);
        var encodedTextBuilder = new StringBuilder(text.Length);
        for (var i = 0; i < text.Length; i++)
        {
            if (!char.IsLetter(text[i]))
            {
                _ = encodedTextBuilder.Append(text[i]);
                continue;
            }

            var letterZ = char.IsUpper(key[i]) ? 'Z' : 'z';
            var encodedSymbol = symbolCipher(text[i].ToString(), letterZ - key[i]);
            _ = encodedTextBuilder.Append(encodedSymbol);
        }

        return encodedTextBuilder.ToString();
    }

    private string AppendKey(string key, int length)
    {
        if (string.IsNullOrEmpty(key))
        {
            throw new ArgumentOutOfRangeException($"{nameof(key)} must be non-empty string");
        }

        var keyBuilder = new StringBuilder(key, length);
        while (keyBuilder.Length < length)
        {
            _ = keyBuilder.Append(key);
        }

        return keyBuilder.ToString();
    }
}
