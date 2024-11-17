using Algorithms.Crypto.Exceptions;
using NUnit.Framework;
using FluentAssertions;
using System;

namespace Algorithms.Tests.Crypto.Exceptions
{
    [TestFixture]
    public class CryptoExceptionTests
    {
        [Test]
        public void CryptoException_ShouldBeCreatedWithoutMessageOrInnerException()
        {
            
            var exception = new CryptoException();

            exception.Should().BeOfType<CryptoException>()
                .And.Subject.As<CryptoException>()
                .Message.Should().NotBeNullOrEmpty();
            exception.InnerException.Should().BeNull();
        }

        [Test]
        public void CryptoException_ShouldSetMessage()
        {
            
            var expectedMessage = "This is a custom cryptographic error.";

            var exception = new CryptoException(expectedMessage);

            exception.Should().BeOfType<CryptoException>()
                .And.Subject.As<CryptoException>()
                .Message.Should().Be(expectedMessage);
            exception.InnerException.Should().BeNull();
        }

        [Test]
        public void CryptoException_ShouldSetMessageAndInnerException()
        {
            
            var expectedMessage = "An error occurred during encryption.";
            var innerException = new InvalidOperationException("Invalid operation");

            var exception = new CryptoException(expectedMessage, innerException);

            exception.Should().BeOfType<CryptoException>()
                .And.Subject.As<CryptoException>()
                .Message.Should().Be(expectedMessage);
            exception.InnerException.Should().Be(innerException);
        }

        [Test]
        public void CryptoException_MessageShouldNotBeNullWhenUsingDefaultConstructor()
        {
            
            var exception = new CryptoException();

            exception.Message.Should().NotBeNullOrEmpty(); 
        }
    }
}

