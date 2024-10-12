
//Queue using two stack: Method 2:Rechcek not sure correct
import java.util.*;
//
public class E2 {
    static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }
              
        //add- O(1)
        public static void add(int data) {
            s1.push(data);
        }

        //remove-O(n)
        public static int remove() {
            if(isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            while(s1.size() > 1) {
                s2.push(s1.pop());
            }
            int result = s1.pop();
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return result;
        }

        //peek-O(N)
        public static int peek() {
            if(isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            while(s1.size() > 1) {
                s2.push(s1.pop());
            }
            int result = s1.peek();
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return result;
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
