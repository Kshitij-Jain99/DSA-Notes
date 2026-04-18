// Reverse a string using Stack:

import java.util.Stack;

public class F {

    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        StringBuilder result = new StringBuilder(str.length());

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.toString();
    }
}

