import java.util.*;

public class H {
//2
   public static void stocksSpan(int stocks[], int span[]) {
    Stack<Integer> s = new Stack<>();
    span[0] =1;  //inital value
    s.push(0);   //initialize stack
    
    //Checking span of each day by index
    for(int i =1; i<stocks.length; i++) {
        int currPrice = stocks[i];
        while(!s.isEmpty() && currPrice > stocks[s.peek()]) {
            s.pop();   //removing relatively smaller  elements from stack
        }
        if(s.isEmpty()) {
            span[i] = i+1;  // in given stocks arr, 100 shows i+1 span
        } else {            //in given arr, rest ae showing this span 
            int prevHigh = s.peek();
            span[i] = i- prevHigh;
        }

        s.push(i);
      }
   }
    public static void main(String args[]) {
//1       
        int stocks[] = {100,80,60,70,60,85,100};
        int span[] = new  int[stocks.length];
        stocksSpan(stocks, span);

        for(int i=0; i<span.length; i++) {
            System.out.println(span[i]+ " ");
        }

    }
    
}
