using System;
using System.Collections.Generic;

namespace Algorithms.Stack
{
    
    public class NextGreaterElement
    {
        
        public int[] FindNextGreaterElement(int[] nums)
        {
            int[] result = new int[nums.Length];
            Stack<int> stack = new Stack<int>();

            for (int i = 0; i < nums.Length; i++)
            {
                result[i] = -1;
            }

            for (int i = 0; i < nums.Length; i++)
            {
                
                while (stack.Count > 0 && nums[i] > nums[stack.Peek()])
                {
                    int index = stack.Pop();
                    result[index] = nums[i]; 
                }

                stack.Push(i); 
            }

            return result;
        }
    }
}
