// Circular Linked List 

class H {

    static class Node {
        int data;
        Node next;
        Node(int d) { 
             data = d;
             next = null; 
        }
    }

    //--------------Adding a node-----------------
    static Node addToEmpty(Node last, int data) {
        if (last != null)  return last;

        // For empty list -> Create single node Circular list
        Node newNode = new Node(data);
        last = newNode;
        newNode.next = last; // circular to itself/node point to itself (first == last.)
        return last;
    }

    static Node addFront(Node last, int data) {
        if (last == null) return addToEmpty(last, data);
        
        Node newNode = new Node(data);

        newNode.next = last.next; //Store the address of the current first node in the newNode
        last.next = newNode;      // point the last node to the newNode
        
        return last;
    }

    static Node addEnd(Node last, int data) {
        if (last == null) return addToEmpty(last, data);
        
        Node newNode = new Node(data);
        
        newNode.next = last.next; //Insert the address of the head node to the next of newNode
        last.next = newNode;      // pointing the current last node to newNode
        last = newNode;
        
        return last;
    }

    static Node addAfter(Node last, int data, int item) { //Insert a new node after the node whose value = item.
        if (last == null) return null;
        //last : pointer to the last node in the circular list
        //data : value to insert
        //item : value after which to insert the new node
        Node p = last.next;  // In a circular list: last.next = first node
        do {
            if (p.data == item) {
                Node newNode = new Node(data);
                newNode.next = p.next;
                p.next = newNode;
                if (p == last)
                    last = newNode;
                return last;
            }
            p = p.next;
        } while (p != last.next);
        
        System.out.println(item + " : The given node is not present in the list");
        return last;
    }

    //--------------Deleting a node-----------------
    static Node deleteNode(Node last, int key) { //Remove the node whose value equals key
        if (last == null) return null;

        // Only one node
        if (last.data == key && last.next == last) {
            return null;
        }

        Node curr = last.next;
        Node prev = last;

        // If node to be deleted is the first node (last.next)
        if (curr.data == key) {
            prev.next = curr.next; // remove first node
            return last; // last unchanged
        }

        // Search for the node to delete
        while (curr != last && curr.data != key) {
            prev = curr;
            curr = curr.next;
        }

        // If found and it's not the last node
        if (curr.data == key) {
            prev.next = curr.next;
            // If it's the last node, update last pointer
            if (curr == last) {
                last = prev;
            }
        } else {
            // key not found
            System.out.println("Key " + key + " not found in the list.");
        }
        return last;
    }

    //--------------Traversing the list---------------
    static void traverse(Node last) {
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }
        Node p = last.next;
        do {
            System.out.print(p.data + " ");
            p = p.next;
        } while (p != last.next);
        System.out.println();
    }

    public static void main(String[] args) {
        Node last = null;
        last = addToEmpty(last, 6);   // list: 6
        last = addEnd(last, 8);       // list: 6 8
        last = addFront(last, 2);     // list: 2 6 8
        last = addAfter(last, 10, 2); // after node 2 -> list: 2 10 6 8
        traverse(last);               // prints: 2 10 6 8
        last = deleteNode(last, 8);   // delete 8 (last node), must assign back
        traverse(last);               // prints: 2 10 6
    }
}
