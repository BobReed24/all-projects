using System;
using System.Collections.Generic;

namespace Algorithms.Stack
{
    
    public class BalancedParenthesesChecker
    {
        private static readonly Dictionary<char, char> ParenthesesMap = new Dictionary<char, char>
        {
            { '(', ')' },
            { '{', '}' },
            { '[', ']' },
        };

        public bool IsBalanced(string expression)
        {
            if (string.IsNullOrEmpty(expression))
            {
                throw new ArgumentException("The input expression cannot be null or empty.");
            }

            Stack<char> stack = new Stack<char>();
            foreach (char c in expression)
            {
                if (IsOpeningParenthesis(c))
                {
                    stack.Push(c);
                }
                else if (IsClosingParenthesis(c))
                {
                    if (!IsBalancedClosing(stack, c))
                    {
                        return false;
                    }
                }
                else
                {
                    throw new ArgumentException($"Invalid character '{c}' found in the expression.");
                }
            }

            return stack.Count == 0;
        }

        private static bool IsOpeningParenthesis(char c)
        {
            return c == '(' || c == '{' || c == '[';
        }

        private static bool IsClosingParenthesis(char c)
        {
            return c == ')' || c == '}' || c == ']';
        }

        private static bool IsBalancedClosing(Stack<char> stack, char close)
        {
            if (stack.Count == 0)
            {
                return false;
            }

            char open = stack.Pop();
            return IsMatchingPair(open, close);
        }

        private static bool IsMatchingPair(char open, char close)
        {
            return ParenthesesMap.ContainsKey(open) && ParenthesesMap[open] == close;
        }
    }
}
