using System;
using System.Collections.Generic;

namespace Algorithms.Stack
{
    
    public class ReverseStack
    {
        
        public void Reverse<T>(Stack<T> stack)
        {
            if (stack.Count == 0)
            {
                return;
            }

            T temp = stack.Pop();
            Reverse(stack);
            InsertAtBottom(stack, temp);
        }

        private void InsertAtBottom<T>(Stack<T> stack, T value)
        {
            if (stack.Count == 0)
            {
                stack.Push(value);
            }
            else
            {
                T temp = stack.Pop();
                InsertAtBottom(stack, value);
                stack.Push(temp);
            }
        }
    }
}
