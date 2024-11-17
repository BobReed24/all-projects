using Algorithms.Encoders;
using NUnit.Framework;
using NUnit.Framework.Internal;

namespace Algorithms.Tests.Encoders;

public static class CaesarEncoderTests
{
    [Test]
    public static void DecodedStringIsTheSame([Random(100)] int key)
    {
        
        var encoder = new CaesarEncoder();
        var random = new Randomizer();
        var message = random.GetString();

        var encoded = encoder.Encode(message, key);
        var decoded = encoder.Decode(encoded, key);

        Assert.That(decoded, Is.EqualTo(message));
    }
}
