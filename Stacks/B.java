// Stack implemented using ArrayList:

import java.util.ArrayList;

public class B {

    final private static ArrayList<Integer> al = new ArrayList<>();
    
    public static boolean isEmpty(){ 
        return al.isEmpty();   
    }    
    
    // push
    public static void push(int data) {  //this fxn add data on top of stack or last element of ArrayList
        al.add(data);   
    }

    // pop
    public static int pop() {
        if(isEmpty()) {    
            return -1;
        }
        int top = al.get(al.size()-1);    
        al.remove(al.size()-1);        // top remove
        return top;
    }
    
    // peek
    public static int peek() {
        if(isEmpty()) {
            return -1;
        }
        return al.get (al.size()-1);
    }
}  
