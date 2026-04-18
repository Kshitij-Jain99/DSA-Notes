// Stock Span Problem: (Previous Greater Element)

import java.util.*;

public class H {

    // Approach-1: Monotonic decreasing Stack
    // TC = O(2.n){Each element pushed and Popped once only}, SC = O(n)
    public static void stocksSpan1(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();

        // Initial stock add
        span[0] = 1;    
        s.push(0);   
        
        // Checking span of each day by index
        for(int i = 1; i<stocks.length; i++){
            int currPrice = stocks[i];

            while(!s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();   //removing relatively smaller elements from stack
            }
            if(s.isEmpty()) {
                span[i] = i + 1;      
            } else {             
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    // Approach-2(Faster): Using ArrayDeque
    // TC = O(N), SC = O(N)
    /*
        1. Stack in Java is synchronized and slower
    */
    public static int[] stockSpan2(int[] stocks) {
        int n = stocks.length;
        int[] span = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            
            while (!stack.isEmpty() && stocks[i] >= stocks[stack.peek()]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }
            
            stack.push(i);
        }
        return span;
    }
}
