public class F { 
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList {
        public Node head;
        public Node tail;
        public int size;
        
        public LinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
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

       
        public void zigZag() {
            //fin mid
            Node slow = head;
            Node fast = head.next;
            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            Node mid = slow;

            //reverse 2nd half
            Node curr = mid.next;
            mid.next= null;
            Node prev = null;
            Node next;

            while(curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            Node left = head;
            Node right = prev;
            Node nextL, nextR;

            //alt. merge-- zigZag merge
             while(left != null && right != null) {
                nextL = left.next;
                left.next = right;
                nextR = right.next;
                right.next = nextL;

                left = nextL;
                right = nextR;
             }
        }
    }
       

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new Node(5);
        ll.head.next = new Node(4);
        ll.head.next.next = new Node(3);
        ll.head.next.next.next = new Node(2);
        ll.head.next.next.next.next = new Node(1);

        ll.print();
        ll.zigZag();
        ll.print();
    }
}
