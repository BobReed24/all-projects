using NUnit.Framework;
using FluentAssertions;
using System;
using Algorithms.Crypto.Utils;
using Algorithms.Crypto.Exceptions;

namespace Algorithms.Tests.Crypto.Utils
{
    [TestFixture]
    public class ValidationUtilsTests
    {
        [Test]
        public void CheckDataLength_WithBufferOutOfBounds_ShouldThrowDataLengthException()
        {
            
            var buffer = new byte[5];  
            var offset = 3;               
            var length = 4;               
            var errorMessage = "Buffer is too short";

            var act = () => ValidationUtils.CheckDataLength(buffer, offset, length, errorMessage);

            act.Should().Throw<DataLengthException>()
                .WithMessage(errorMessage);
        }

        [Test]
        public void CheckOutputLength_WithCondition_ShouldThrowOutputLengthException()
        {
            
            var condition = true;
            var errorMessage = "Output length is invalid";

            var act = () => ValidationUtils.CheckOutputLength(condition, errorMessage);

            act.Should().Throw<OutputLengthException>()
               .WithMessage(errorMessage);
        }

        [Test]
        public void CheckOutputLength_WithCondition_ShouldNotThrowOutputLengthException()
        {
            
            var condition = false;
            var errorMessage = "Output length is invalid";

            var act = () => ValidationUtils.CheckOutputLength(condition, errorMessage);

            act.Should().NotThrow<OutputLengthException>();
        }

        [Test]
        public void CheckOutputLength_WithBufferOutOfBounds_ShouldThrowOutputLengthException()
        {
            
            var buffer = new byte[5];
            var offset = 3;
            var length = 4;
            var errorMessage = "Output buffer is too short";

            var act = () => ValidationUtils.CheckOutputLength(buffer, offset, length, errorMessage);

            act.Should().Throw<OutputLengthException>()
               .WithMessage(errorMessage);
        }

        [Test]
        public void CheckOutputLength_WithBProperBufferSize_ShouldThrowOutputLengthException()
        {
            
            var buffer = new byte[5];
            var offset = 0;
            var length = 4;
            var errorMessage = "Output buffer is too short";

            var act = () => ValidationUtils.CheckOutputLength(buffer, offset, length, errorMessage);

            act.Should().NotThrow<OutputLengthException>();
        }

        [Test]
        public void CheckOutputLength_SpanExceedsLimit_ShouldThrowOutputLengthException()
        {
            
            Span<byte> output = new byte[10];
            var outputLength = output.Length;
            var maxLength = 5;
            var errorMessage = "Output exceeds maximum length";

            var act = () => ValidationUtils.CheckOutputLength(outputLength > maxLength, errorMessage); 

            act.Should().Throw<OutputLengthException>()
                .WithMessage(errorMessage);
        }

        [Test]
        public void CheckOutputLength_SpanDoesNotExceedLimit_ShouldThrowOutputLengthException()
        {
            
            Span<byte> output = new byte[10];
            var outputLength = output.Length;
            var maxLength = 15;
            var errorMessage = "Output exceeds maximum length";

            var act = () => ValidationUtils.CheckOutputLength(outputLength > maxLength, errorMessage); 

            act.Should().NotThrow<OutputLengthException>();
        }
    }
}
