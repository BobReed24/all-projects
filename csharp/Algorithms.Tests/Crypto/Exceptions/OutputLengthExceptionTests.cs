using NUnit.Framework;
using FluentAssertions;
using System;
using Algorithms.Crypto.Exceptions;

namespace Algorithms.Tests.Crypto.Exceptions
{
    [TestFixture]
    public class OutputLengthExceptionTests
    {
        [Test]
        public void OutputLengthException_ShouldBeCreatedWithoutMessageOrInnerException()
        {
            
            var exception = new OutputLengthException();

            exception.Should().BeOfType<OutputLengthException>()
                .And.Subject.As<OutputLengthException>()
                .Message.Should().NotBeNullOrEmpty();
            exception.InnerException.Should().BeNull();
        }

        [Test]
        public void OutputLengthException_ShouldSetMessage()
        {
            
            var expectedMessage = "Output buffer is too short.";

            var exception = new OutputLengthException(expectedMessage);

            exception.Should().BeOfType<OutputLengthException>()
                .And.Subject.As<OutputLengthException>()
                .Message.Should().Be(expectedMessage);
            exception.InnerException.Should().BeNull();
        }

        [Test]
        public void OutputLengthException_ShouldSetMessageAndInnerException()
        {
            
            var expectedMessage = "Output length error.";
            var innerException = new ArgumentException("Invalid argument");

            var exception = new OutputLengthException(expectedMessage, innerException);

            exception.Should().BeOfType<OutputLengthException>()
                .And.Subject.As<OutputLengthException>()
                .Message.Should().Be(expectedMessage);
            exception.InnerException.Should().Be(innerException);
        }

        [Test]
        public void OutputLengthException_MessageShouldNotBeNullWhenUsingDefaultConstructor()
        {
            
            var exception = new OutputLengthException();

            exception.Message.Should().NotBeNullOrEmpty(); 
        }
    }
}
