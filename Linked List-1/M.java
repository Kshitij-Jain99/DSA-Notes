public class M {
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
   
    //slow fast approach-step1
  public Node findMid(Node head) {
    Node slow =head;
    Node fast = head;

    while(fast!= null && fast.next != null){
        slow = slow.next; //+1
        fast = fast.next.next;  //+2

    }
    return slow; //slow is my mid node
  }

  public boolean checkPalindrome(){
    //base case- 0  and 1 element LL is a palindrome
    if(head == null || head.next== null){
        return true;
    }
      //step-1 - find mid
    Node midNode = findMid(head);
    
      //step-2- reverse 2nd half:similar code as {K} but theinitialization is different
        Node prev = null;
        Node curr = midNode; //modification from {K}
        Node next;
        while(curr != null) {
             next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
        }
        Node right = prev; //right half head
        Node left = head;

      //step-3--check left and right half
      while(right != null){
        if(left.data!= right.data) {
            return false;
        }
        left = left.next;
        right= right.next;
      }
      return true;
  }

    public static void main(String args[]) {
        M ll = new M();  // Create instance of custom LinkedList
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(1);
        ll.print();

        System.out.println(ll.checkPalindrome());
        

    }
}
