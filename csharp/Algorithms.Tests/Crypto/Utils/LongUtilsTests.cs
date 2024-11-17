using NUnit.Framework;
using FluentAssertions;
using Algorithms.Crypto.Utils;

namespace Algorithms.Tests.Crypto.Utils
{
    [TestFixture]
    public class LongUtilsTests
    {
        [Test]
        public void RotateLeft_Long_ShouldRotateCorrectly()
        {
            
            var input = 0x0123456789ABCDEF;
            var distance = 8;
            var expected = 0x23456789ABCDEF01L;  

            var result = LongUtils.RotateLeft(input, distance);

            result.Should().Be(expected);
        }

        [Test]
        public void RotateLeft_Ulong_ShouldRotateCorrectly()
        {
            
            var input = 0x0123456789ABCDEFUL;
            var distance = 8;
            var expected = 0x23456789ABCDEF01UL;  

            var result = LongUtils.RotateLeft(input, distance);

            result.Should().Be(expected);
        }

        [Test]
        public void RotateRight_Long_ShouldRotateCorrectly()
        {
            
            var input = 0x0123456789ABCDEF;
            var distance = 8;
            var expected = unchecked((long)0xEF0123456789ABCD);  

            var result = LongUtils.RotateRight(input, distance);

            result.Should().Be(expected);
        }

        [Test]
        public void RotateRight_Ulong_ShouldRotateCorrectly()
        {
            
            var input = 0x0123456789ABCDEFUL;
            var distance = 8;
            var expected = 0xEF0123456789ABCDUL;  

            var result = LongUtils.RotateRight(input, distance);

            result.Should().Be(expected);
        }

        [Test]
        public void RotateLeft_Long_ShouldHandleZeroRotation()
        {
            
            var input = 0x0123456789ABCDEF;
            var distance = 0;

            var result = LongUtils.RotateLeft(input, distance);

            result.Should().Be(input);  
        }

        [Test]
        public void RotateRight_Ulong_ShouldHandleFullRotation()
        {
            
            var input = 0x0123456789ABCDEFUL;
            var distance = 64;

            var result = LongUtils.RotateRight(input, distance);

            result.Should().Be(input);  
        }
    }
}
