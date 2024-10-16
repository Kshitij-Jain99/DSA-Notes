import java.util.LinkedList;

public class B1 {
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

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();  //ll is oject
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
        //For writing these for both head and tail we create methods
    }

}
