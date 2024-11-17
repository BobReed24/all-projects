using Algorithms.Encoders;
using FluentAssertions;
using NUnit.Framework;

namespace Algorithms.Tests.Encoders;

public class BlowfishEncoderTests
{
    private const string Key = "aabb09182736ccdd";

    [Test]
    public void BlowfishEncoder_Encryption_ShouldWorkCorrectly()
    {
        
        var encoder = new BlowfishEncoder();
        encoder.GenerateKey(Key);

        const string plainText = "123456abcd132536";
        const string cipherText = "d748ec383d3405f7";

        var result = encoder.Encrypt(plainText);

        result.Should().Be(cipherText);
    }

    [Test]
    public void BlowfishEncoder_Decryption_ShouldWorkCorrectly()
    {
        
        var encoder = new BlowfishEncoder();
        encoder.GenerateKey(Key);

        const string cipherText = "d748ec383d3405f7";
        const string plainText = "123456abcd132536";

        var result = encoder.Decrypt(cipherText);

        result.Should().Be(plainText);
    }
}
