public class I {
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
   
    public int itrSearch(int key) {
        Node temp = head;
        int i=0;

        while(temp != null) {
            if(temp.data == key) {
                //key found
                return i;
            }
            temp = temp.next;
            i++;
        }
        //key not found
        return -1;
    }

    public static void main(String args[]) {
        I ll = new I();  // Create instance of custom LinkedList
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.print();

        System.out.println(ll.itrSearch(3));
        System.out.println(ll.itrSearch(10));

    }
}
