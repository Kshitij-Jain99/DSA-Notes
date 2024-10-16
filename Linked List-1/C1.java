import java.util.LinkedList;

public class C1 {
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
        //step-1 = create new node
        Node newNode = new Node(data);  //ClassName objectName = new ClassName(constructor keyword)
        
        if(head== null) {  //when linked list is empty
              head = tail = newNode;
        }
        

        //step-2-- newNode next = head
        newNode.next = head; //linking step

        //step-3--  head=newNode
        head = newNode;
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();  //ll is oject
        ll.addFirst(1);
        ll.addFirst(2);
        

   }
}   
