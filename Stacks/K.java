// Duplicate Parentheses

import java.util.*;

public class K {
    // Approach-1:
    // TC = O(), SC = O()
    public static boolean isDuplicate1(String str) {
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == ')') {
                int count = 0;
                while(!s.isEmpty() && s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if(count < 1) {
                    return true;  // duplicate
                } else {
                    s.pop();  // opening pair
                }
            } else {
                // opening
                s.push(ch);
            }
        }

        return false;
    }

    // Approach-2:
    // TC = O(), SC = O()
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == ')') {
                int count = 0;
                while( s.pop() != '(') {
                    count++;
                }
                if(count < 1) {
                    return true;  // duplicate
                } 
            } else {
                // opening
                s.push(ch);
            }
        }

        return false;
    }
}
