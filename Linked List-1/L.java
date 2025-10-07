//Find and Remove Nth Node from End
public class L {
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
   
   public void deleterNthfromEnd(int n) {
    //calculate size
    int sz =0;
    Node temp = head;
    while(temp!= null){
        temp = temp.next;
        sz++;
     }
     //corner case- when head is needed to be deleted
     if(n ==sz) {
        head = head.next; //removefirst
        return;
      
   }

   //sz-n for rem. all cases ; node to be deleted sein phele  index tak
   int i=1;
   int iToFind = sz-n;
   Node prev = head;
   while(i< iToFind) {
    prev = prev.next;
    i++;
   }

   prev.next = prev.next.next;
   return;
}
    public static void main(String args[]) {
        L ll = new L();  // Create instance of custom LinkedList
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.print();

        ll.deleterNthfromEnd(3);
        ll.print();

    }
}
