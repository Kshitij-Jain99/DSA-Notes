// Doubly Linked List implementation
public class G {
    // Node class
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public G() {
        head = null;
        tail = null;
        size = 0;
    }

    // ---------- Basic helpers ----------
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    // ---------- Add operations ----------
    // add at beginning : O(1)
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) { // empty
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // add at end : O(1)
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) { // empty
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // add at index (0-based) : O(n) in worst case
    public void addAt(int index, int data) {  
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index: " + index);
        if (index == 0) { addFirst(data); return; }
        if (index == size) { addLast(data); return; }

        Node newNode = new Node(data);
        Node cur = getNodeAt(index); 
        Node prev = cur.prev;

        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = cur;
        cur.prev = newNode;
        size++;
    }

    // ---------- Remove operations ----------
    // remove from front: O(1)
    public int removeFirst() {
        if (head == null) throw new RuntimeException("List is empty");
        int val = head.data;
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return val;
    }

    // remove from end : O(1)
    public int removeLast() {
        if (tail == null) throw new RuntimeException("List is empty");
        int val = tail.data;
        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return val;
    }

    // remove at index, return removed value
    public int removeAt(int index) { // O(n) in worst case
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index);
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast(); //index == size is NOT allowed.

        Node cur = getNodeAt(index);
        Node p = cur.prev;
        Node n = cur.next;

        p.next = n;
        n.prev = p;
        size--;
        return cur.data;
    }

    // ---------- Access/search ----------
    // get value at index : O(n) in worst case
    public int get(int index) {
        Node n = getNodeAt(index);
        return n.data;
    }

    // returns true if value present: O(n)
    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    // indexOf value (first occurrence) or -1 : O(n)
    public int indexOf(int value) {
        Node temp = head;
        int idx = 0;
        while (temp != null) {
            if (temp.data == value) return idx;
            temp = temp.next;
            idx++;
        }
        return -1;
    }

    // helper: get Node reference at index (optimized: from head or tail)
    private Node getNodeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index);
        Node cur;
        if (index < size / 2) {
            cur = head;
            for (int i = 0; i < index; i++) cur = cur.next;
        } else {
            cur = tail;
            for (int i = size - 1; i > index; i--) cur = cur.prev;
        }
        return cur;
    }

    // reverse list : O(n)
    public void reverse() { 
        Node curr = head;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // reverse list in-place, similar to singley LL: O(n)
    public void reverse2() { 
        Node cur = head;
        Node tmp = null; //tmp contains the previous pointer of the last processed node
        while (cur != null) {
            // swap next and prev
            tmp = cur.prev;
            cur.prev = cur.next;
            cur.next = tmp;

            //moves forward in the original direction
            cur = cur.prev; // because we swapped, prev is the original next
        }
        // swap head and tail
        if (tmp != null) {  
            head = tmp.prev; // tmp is last processed node's prev
        }
    }

    // clear list: O(n)
    public void clear() {
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.prev = cur.next = null;
            cur = next;
        }
        head = tail = null;
        size = 0;
    }

    // ---------- Print helpers ----------
    public void printForward() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + (cur.next != null ? " <-> " : ""));
            cur = cur.next;
        }
        System.out.println();
    }

    public void printBackward() {
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.data + (cur.prev != null ? " <-> " : ""));
            cur = cur.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        G dll = new G();
        dll.addFirst(3);          // 3
        dll.addFirst(2);          // 2 <-> 3
        dll.addFirst(1);          // 1 <-> 2 <-> 3
        dll.addLast(4);           // 1 <-> 2 <-> 3 <-> 4
        dll.addAt(2, 99);         // 1 <-> 2 <-> 99 <-> 3 <-> 4

        System.out.print("Forward: "); dll.printForward();
        System.out.print("Backward: "); dll.printBackward();

        System.out.println("Removed at 2: " + dll.removeAt(2)); // removes 99
        System.out.print("After remove: "); dll.printForward();

        System.out.println("Contains 3? " + dll.contains(3));
        System.out.println("Index of 4: " + dll.indexOf(4));

        dll.reverse();
        System.out.print("Reversed: "); dll.printForward();

        System.out.println("Size: " + dll.size());
        dll.clear();
        System.out.println("Cleared, size: " + dll.size());
    }
}
