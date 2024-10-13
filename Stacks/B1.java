import java.util.ArrayList;

public class B1 {
   public static class Stack {
    private static ArrayList<Integer> list = new ArrayList<>();
    public static boolean isEmpty(){
    return list.size() == 0;   //if list is empty then we return true
    }    
    
    //push
    public static void push(int data) {
        list.add(data);   //this fxn add data on top of stack or last element of ArrayList
    }

    //pop
    public static int pop() {
        if(isEmpty()) {    //corner case, when it return true we return -1
            return -1;
        }
        int top = list.get(list.size()-1); //top nikala
        list.remove(list.size()-1);        //top remove
        return top;
    }
    
    //PEEK
    public static int peek() {
        if(isEmpty()) {
            return -1;
        }
        return list.get (list.size()-1);
    }
}

public static void main (String args[]) {
    Stack s = new Stack();
    s.push(1);
    s.push(2);
    s.push(3);

    while(!s.isEmpty()) {
        System.out.println(s.peek());
        s.pop();
    }
  }
}  
