// Valid Parentheses

import java.util.*;

public class J {
    // Approach-1: Stack
    // TC = O(2.N), SC = O(N)
    public static boolean isValid1(String str) {
        Stack<Character> s = new Stack<>();

        for(int i = 0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(' || ch == '{' || ch == '[') {
            s.push(ch);  // Opening 
            } else{
                //closing
                if(s.isEmpty()) {  // only closing brackets present in str:"))))}}]"
                    return false;
                }
                if((s.peek() == '(' && ch == ')') //()
                    || (s.peek() == '{' && ch == '}')  //{}
                    || (s.peek() == '[' && ch == ']')){ //[]
                        s.pop();
                    } else{
                        return false;
                    }

                }
            }

            if(s.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }


    // Approach-2(Faster): ArrayDeque
    // TC = O(N), SC = O(N)
    public boolean isValid2(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            
            // Push expected closing bracket
            if (ch == '(') stack.push(')');
            else if (ch == '{') stack.push('}');
            else if (ch == '[') stack.push(']');
            else {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
