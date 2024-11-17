package com.thealgorithms.stacks;

import java.util.LinkedList;

public class PalindromeWithStack {
    private LinkedList<Character> stack;

    public PalindromeWithStack() {
        stack = new LinkedList<Character>();
    }

    public boolean checkPalindrome(String string) {
        
        StringBuilder stringBuilder = new StringBuilder(string.length());
        
        String lowercase = string.toLowerCase();

        for (int i = 0; i < lowercase.length(); ++i) {
            char c = lowercase.charAt(i);
            
            stringBuilder.append(c);
            
            stack.push(c);
        }

        StringBuilder reverseString = new StringBuilder(stack.size());
        
        while (!stack.isEmpty()) {
            
            reverseString.append(stack.pop());
        }

        return reverseString.toString().equals(stringBuilder.toString());
    }
}
