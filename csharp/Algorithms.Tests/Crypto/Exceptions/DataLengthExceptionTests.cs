using NUnit.Framework;
using FluentAssertions;
using System;
using Algorithms.Crypto.Exceptions;

namespace Algorithms.Tests.Crypto.Exceptions
{
    [TestFixture]
    public class DataLengthExceptionTests
    {
        [Test]
        public void DataLengthException_ShouldBeCreatedWithoutMessageOrInnerException()
        {
            
            var exception = new DataLengthException();

            exception.Should().BeOfType<DataLengthException>()
                .And.Subject.As<DataLengthException>()
                .Message.Should().NotBeNullOrEmpty();
            exception.InnerException.Should().BeNull();
        }

        [Test]
        public void DataLengthException_ShouldSetMessage()
        {
            
            var expectedMessage = "Data length is invalid.";

            var exception = new DataLengthException(expectedMessage);

            exception.Should().BeOfType<DataLengthException>()
                .And.Subject.As<DataLengthException>()
                .Message.Should().Be(expectedMessage);
            exception.InnerException.Should().BeNull();
        }

        [Test]
        public void DataLengthException_ShouldSetMessageAndInnerException()
        {
            
            var expectedMessage = "An error occurred due to incorrect data length.";
            var innerException = new ArgumentException("Invalid argument");

            var exception = new DataLengthException(expectedMessage, innerException);

            exception.Should().BeOfType<DataLengthException>()
                .And.Subject.As<DataLengthException>()
                .Message.Should().Be(expectedMessage);
            exception.InnerException.Should().Be(innerException);
        }

        [Test]
        public void DataLengthException_MessageShouldNotBeNullWhenUsingDefaultConstructor()
        {
            
            var exception = new DataLengthException();

            exception.Message.Should().NotBeNullOrEmpty(); 
        }
    }
}
