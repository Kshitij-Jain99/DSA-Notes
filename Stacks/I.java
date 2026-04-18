// Next Greater Element

import java.util.*;

public class I {

    // Approach-1: Monotonic Decreasing Stack
    // TC = O(2.N), SC = O(N)    
    public void findNextGreater1(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int nxtGreater[] = new int[arr.length];

        for(int i = arr.length - 1; i >= 0; i--) {
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    // Approach-2(Faster): ArrayDeque
    // TC = O(N), SC = O(N)
        public void nextGreaterElement2(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
    }
}
