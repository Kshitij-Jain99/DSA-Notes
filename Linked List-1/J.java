//Recursive Search

public class J {
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

    public int helper(Node head, int key){  //real recursive fxn with 2 parameters
       if(head == null) {
        return -1;
       }

       if(head.data == key) {
        return 0;
       }
       int idx = helper(head.next, key); //key nahi mili
       if(idx == -1){
        return -1;
       }

       return idx+1; //key mil gyi
    }
    public int recSearch(int key) {
        return helper(head, key);
    }

    public static void main(String args[]) {
        J ll = new J();  // Create instance of custom LinkedList
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.print();

        System.out.println(ll.recSearch(3));
        System.out.println(ll.recSearch(10));

    }
}
