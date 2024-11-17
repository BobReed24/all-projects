using NUnit.Framework;
using FluentAssertions;
using System;
using Algorithms.Crypto.Utils;

namespace Algorithms.Tests.Crypto.Utils
{
    [TestFixture]
    public class ByteEncodingUtilsTests
    {
        [Test]
        public void BigEndianToUint64_ByteArray_ShouldConvertCorrectly()
        {
            
            byte[] input = { 0x01, 0x23, 0x45, 0x67, 0x89, 0xAB, 0xCD, 0xEF };
            var expected = 0x0123456789ABCDEFUL;

            var result = ByteEncodingUtils.BigEndianToUint64(input, 0);

            result.Should().Be(expected);
        }

        [Test]
        public void BigEndianToUint64_ByteArray_WithOffset_ShouldConvertCorrectly()
        {
            
            byte[] input = { 0x00, 0x00, 0x01, 0x23, 0x45, 0x67, 0x89, 0xAB, 0xCD, 0xEF };
            var expected = 0x0123456789ABCDEFUL;

            var result = ByteEncodingUtils.BigEndianToUint64(input, 2);

            result.Should().Be(expected);
        }

        [Test]
        public void BigEndianToUint64_Span_ShouldConvertCorrectly()
        {
            
            Span<byte> input = stackalloc byte[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xAB, 0xCD, 0xEF };
            var expected = 0x0123456789ABCDEFUL;

            var result = ByteEncodingUtils.BigEndianToUint64(input);

            result.Should().Be(expected);
        }

        [Test]
        public void UInt64ToBigEndian_ShouldWriteCorrectly()
        {
            
            var value = 0x0123456789ABCDEFUL;
            Span<byte> output = stackalloc byte[8];
            byte[] expected = { 0x01, 0x23, 0x45, 0x67, 0x89, 0xAB, 0xCD, 0xEF };

            ByteEncodingUtils.UInt64ToBigEndian(value, output);

            output.ToArray().Should().Equal(expected);
        }

        [Test]
        public void BigEndianToUint64_InvalidOffset_ShouldThrowException()
        {
            
            byte[] input = { 0x01, 0x23 };

            Action act = () => ByteEncodingUtils.BigEndianToUint64(input, 1);

            act.Should().Throw<ArgumentOutOfRangeException>();
        }
    }
}
