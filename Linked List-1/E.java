//Print a LL

public class E {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);  
        if(head == null) {  
              head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);  
        if(head == null) {  
              head = tail = newNode;
        } else {
            tail.next = newNode; 
            tail = newNode;
        }
    }

    public void print() {
        if(head == null) {  //BASE CASE
            System.out.println("LL is empty");
            return;
        }
        Node temp = head; 
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        E ll = new E();  // Create instance of custom LinkedList
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addLast(3);
        ll.print();
        ll.addLast(4);
        ll.print();
    }

    public void addM(int i, int j) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addM'");
    }
}
