import java.util.*;

public class F {
   public static void pushAtBottom(Stack<Integer> s, int data) {
    if(s.isEmpty()) {
        s.push(data);
        return;
      }
      int top = s.pop();
      pushAtBottom(s,data);
      s.push(top);
   }
    
   public static String reverseString(String str) {
    Stack<Character> s = new Stack<>();
    int idx = 0;
    while(idx < str.length()) {
        s.push(str.charAt(idx));  //pushing in stack
        idx++;
    }

    StringBuilder result = new StringBuilder("");
    while(!s.isEmpty()) {
        char curr = s.pop();
        result.append(curr);

    }

     return result.toString();                            //str =reesult.toString();
   }
    
    public static void main (String args[]) {
     String str = "abc";
     String result = reverseString(str);
     System.out.println(result);
     
    }
 }
