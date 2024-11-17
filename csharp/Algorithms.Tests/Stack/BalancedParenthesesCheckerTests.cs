using System;
using Algorithms.Stack;
using NUnit.Framework;

namespace Algorithms.Tests.Stack
{
    [TestFixture]
    public class BalancedParenthesesCheckerTests
    {
        public static bool IsBalanced(string expression)
        {
            var checker = new BalancedParenthesesChecker();            
            return checker.IsBalanced(expression);
        }

        [Test]
        public void IsBalanced_EmptyString_ThrowsArgumentException()
        {
            
            var expression = string.Empty;

            var ex = Assert.Throws<ArgumentException>(() => IsBalanced(expression));

            if(ex!=null)
            {
                Assert.That(ex.Message, Is.EqualTo("The input expression cannot be null or empty."));
            }
            
        }

        [Test]
        public void IsBalanced_ValidBalancedExpression_ReturnsTrue()
        {
            
            var expression = "{[()]}";

            var result = IsBalanced(expression);

            Assert.That(result, Is.EqualTo(true));
        }

        [Test]
        public void IsBalanced_ValidUnbalancedExpression_ReturnsFalse()
        {
            
            var expression = "{[(])}";

            var result = IsBalanced(expression);

            Assert.That(result, Is.EqualTo(false));
        }

        [Test]
        public void IsBalanced_UnbalancedWithExtraClosingBracket_ReturnsFalse()
        {
            
            var expression = "{[()]}]";

            var result = IsBalanced(expression);

            Assert.That(result, Is.EqualTo(false));
        }

        [Test]
        public void IsBalanced_ExpressionWithInvalidCharacters_ThrowsArgumentException()
        {
            
            var expression = "{[a]}";

            var ex = Assert.Throws<ArgumentException>(() => IsBalanced(expression));
            if (ex != null)
            {
                Assert.That(ex.Message, Is.EqualTo("Invalid character 'a' found in the expression."));
            }
        }

        [Test]
        public void IsBalanced_SingleOpeningBracket_ReturnsFalse()
        {
            
            var expression = "(";

            var result = IsBalanced(expression);

            Assert.That(result, Is.EqualTo(false));
        }

        [Test]
        public void IsBalanced_SingleClosingBracket_ReturnsFalse()
        {
            
            var expression = ")";

            var result = IsBalanced(expression);

            Assert.That(result, Is.EqualTo(false));
        }

        [Test]
        public void IsBalanced_ExpressionWithMultipleBalancedBrackets_ReturnsTrue()
        {
            
            var expression = "[{()}]()";

            var result = IsBalanced(expression);

            Assert.That(result, Is.EqualTo(true));
        }
    }
}
