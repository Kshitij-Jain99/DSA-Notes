//Remove in LL

public class H {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public  static Node head;
    public static Node tail;
    public static int size;
    

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addM(int idx, int data) {
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < idx - 1 && temp != null) {
            temp = temp.next;
            i++;
        }

        if (temp == null) {
            addFirst(data);
            System.out.println("Index out of bounds");
            return;
        }

        // Insert new node at position idx
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
   //H topic-A
    public int removeFirst() {
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;  //RETURNING AN INVALID VALUE  LIKE - INFINITY
        } else if(size==1) {
            size=0;
            int val = head.data;
            head=tail=null;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

//H topic-B
public int removeLast() {
    if(size==0){
        System.out.println("LL is empty");
        return Integer.MIN_VALUE;  //RETURNING AN INVALID VALUE  LIKE - INFINITY
    } else if(size==1) {
        size=0;
        int val = head.data;
        head=tail=null;
        return val;
    }
    //prev:i = size-2
    Node prev = head;
    for(int i=0; i<size-2; i++) {
        prev = prev.next;
    }
    int val = prev.next.data; //tail.data
    prev.next = null;
    tail = prev;
     size--;
     return val;
}

    public static void main(String args[]) {
        H ll = new H();  // Create instance of custom LinkedList
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addM(2, 8);
        ll.print();
        ll.removeFirst();
        ll.print();

        ll.removeLast();
        ll.print();
    }
}
