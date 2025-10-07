//Add last in LL:

import java.util.LinkedList;

public class D {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);  
        if(head== null) {  
              head = tail = newNode;
              return;
        }
        tail.next = newNode; 
        tail = newNode;
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();  //ll is oject
        ll.addLast(3);
        ll.addLast(4);
        

   }
}   
