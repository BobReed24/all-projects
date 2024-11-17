using System;
using Algorithms.Stack;
using NUnit.Framework;

namespace Algorithms.Tests.Stack
{
    [TestFixture]
    public class NextGreaterElementTests
    {
        private static int[] FindNextGreaterElement(int[] input)
        {
            var obj = new NextGreaterElement();
            return obj.FindNextGreaterElement(input);
        }

        [Test]
        public void FindNextGreaterElement_InputIsEmpty_ReturnsEmptyArray()
        {
            
            int[] input = Array.Empty<int>();
            int[] expected = Array.Empty<int>();

            var result = FindNextGreaterElement(input);

            Assert.That(result, Is.EqualTo(expected));
        }

        [Test]
        public void FindNextGreaterElement_BasicScenario_ReturnsCorrectResult()
        {
            
            int[] input = { 4, 5, 2, 25 };
            int[] expected = { 5, 25, 25, -1 };

            var result = FindNextGreaterElement(input);

            Assert.That(result, Is.EqualTo(expected));
        }

        [Test]
        public void FindNextGreaterElement_NoNextGreaterElement_ReturnsCorrectResult()
        {
            
            int[] input = { 13, 7, 6, 12 };
            int[] expected = { -1, 12, 12, -1 };

            var result = FindNextGreaterElement(input);

            Assert.That(result, Is.EqualTo(expected));
        }

        [Test]
        public void FindNextGreaterElement_AllElementsHaveNoGreaterElement_ReturnsAllNegativeOnes()
        {
            
            int[] input = { 5, 4, 3, 2, 1 };
            int[] expected = { -1, -1, -1, -1, -1 };

            var result = FindNextGreaterElement(input);

            Assert.That(result, Is.EqualTo(expected));
        }

        [Test]
        public void FindNextGreaterElement_InputWithDuplicates_ReturnsCorrectResult()
        {
            
            int[] input = { 4, 4, 3, 2, 4 };
            int[] expected = { -1, -1, 4, 4, -1 };

            var result = FindNextGreaterElement(input);

            Assert.That(result, Is.EqualTo(expected));
        }

        [Test]
        public void FindNextGreaterElement_SingleElementArray_ReturnsNegativeOne()
        {
            
            int[] input = { 10 };
            int[] expected = { -1 };

            var result = FindNextGreaterElement(input);

            Assert.That(result, Is.EqualTo(expected));
        }
    }
}
