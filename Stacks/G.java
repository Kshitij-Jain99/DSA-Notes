// Reverse a Stack:

import java.util.*;

public class G {
    // Approach-1: Iterative(Using Extra Stack)
    // TC = O(n), SC = O(n) {Explicit Stack}
    public static void reverseStack1(Stack<Integer> s){
        Stack<Integer> temp = new Stack<>();

        while(!s.isEmpty()){
            temp.push(s.pop());
        }
    }


    // Approach-2: Recursive
    // TC = O(n^2), SC = O(n) {Implicit Stack}
    public static void pushAtBottom2(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom2(s, data);
        s.push(top);
    }
        
    public static void reverseStack2(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack2(s);
        pushAtBottom2(s, top);
    }    

}