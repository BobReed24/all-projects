using Algorithms.Encoders;
using NUnit.Framework;
using NUnit.Framework.Internal;

namespace Algorithms.Tests.Encoders;

public static class HillEnconderTests
{
    [Test]
    [Repeat(100)]
    public static void DecodedStringIsTheSame()
    {
        
        var encoder = new HillEncoder();
        var random = new Randomizer();
        var message = random.GetString();

        var key = new double[,] { { 0, 4, 5 }, { 9, 2, -1 }, { 3, 17, 7 } };

        var encodedText = encoder.Encode(message, key);
        var decodeText = encoder.Decode(encodedText, key);

        Assert.That(decodeText, Is.EqualTo(message));
    }
}
