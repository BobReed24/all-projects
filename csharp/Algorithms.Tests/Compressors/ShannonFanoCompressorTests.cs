using Algorithms.DataCompression;
using Algorithms.Knapsack;
using NUnit.Framework;
using NUnit.Framework.Internal;

namespace Algorithms.Tests.Compressors;

public static class ShannonFanoCompressorTests
{
    [TestCase("dddddddddd", "1111111111")]
    [TestCase("a", "1")]
    [TestCase("", "")]
    public static void CompressingPhrase(string uncompressedText, string expectedCompressedText)
    {
        
        var solver = new NaiveKnapsackSolver<(char, double)>();
        var translator = new Translator();
        var shannonFanoCompressor = new ShannonFanoCompressor(solver, translator);

        var (compressedText, decompressionKeys) = shannonFanoCompressor.Compress(uncompressedText);
        var decompressedText = translator.Translate(compressedText, decompressionKeys);

        Assert.That(compressedText, Is.EqualTo(expectedCompressedText));
        Assert.That(decompressedText, Is.EqualTo(uncompressedText));
    }

    [Test]
    public static void DecompressedTextTheSameAsOriginal([Random(0, 1000, 100)] int length)
    {
        
        var solver = new NaiveKnapsackSolver<(char, double)>();
        var translator = new Translator();
        var shannonFanoCompressor = new ShannonFanoCompressor(solver, translator);
        var text = Randomizer.CreateRandomizer().GetString(length);

        var (compressedText, decompressionKeys) = shannonFanoCompressor.Compress(text);
        var decompressedText = translator.Translate(compressedText, decompressionKeys);

        Assert.That(decompressedText, Is.EqualTo(text));
    }
}
