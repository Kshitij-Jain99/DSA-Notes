import java.io.*;

public class O1 {
    private Node root; // Root node

    public O1() {
        root = null;
    }

    // Node class for Red-Black Tree
    class Node {
        int data;
        Node left, right, parent;
        char color;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.color = 'R'; // New nodes are always red
            this.parent = null;
        }
    }

    // Perform left rotation
    private Node rotateLeft(Node node) {
        Node x = node.right;
        Node y = x.left;
        x.left = node;
        node.right = y;
        node.parent = x; // Parent resetting is also important.
        if (y != null) y.parent = node;
        return x;
    }

    // Perform right rotation
    private Node rotateRight(Node node) {
        Node x = node.left;
        Node y = x.right;
        x.right = node;
        node.left = y;
        node.parent = x;
        if (y != null) y.parent = node;
        return x;
    }

    // Flags for rotations
    private boolean ll = false;
    private boolean rr = false;
    private boolean lr = false;
    private boolean rl = false;

    // Helper function for insertion
    private Node insertHelp(Node root, int data) {
        boolean f = false; // Flag to check for RED-RED conflict

        // Base case: found the position to insert
        if (root == null) {
            return new Node(data);
        }

        // Recur down the tree
        if (data < root.data) {
            root.left = insertHelp(root.left, data);
            root.left.parent = root;

            if (root != this.root && root.color == 'R' && root.left.color == 'R') {
                f = true;
            }
        } else {
            root.right = insertHelp(root.right, data);
            root.right.parent = root;

            if (root != this.root && root.color == 'R' && root.right.color == 'R') {
                f = true;
            }
        }

        // Perform rotations if needed
        if (this.ll) {
            root = rotateLeft(root);
            root.color = 'B';
            root.left.color = 'R';
            this.ll = false;
        } else if (this.rr) {
            root = rotateRight(root);
            root.color = 'B';
            root.right.color = 'R';
            this.rr = false;
        } else if (this.rl) {
            root.right = rotateRight(root.right);
            root.right.parent = root;
            root = rotateLeft(root);
            root.color = 'B';
            root.left.color = 'R';
            this.rl = false;
        } else if (this.lr) {
            root.left = rotateLeft(root.left);
            root.left.parent = root;
            root = rotateRight(root);
            root.color = 'B';
            root.right.color = 'R';
            this.lr = false;
        }

        // Handle RED-RED conflict
        if (f) {
            if (root.parent.right == root) {
                if (root.parent.left == null || root.parent.left.color == 'B') {
                    if (root.left != null && root.left.color == 'R') this.rl = true;
                    else if (root.right != null && root.right.color == 'R') this.ll = true;
                } else {
                    root.parent.left.color = 'B';
                    root.color = 'B';
                    if (root.parent != this.root) root.parent.color = 'R';
                }
            } else {
                if (root.parent.right == null || root.parent.right.color == 'B') {
                    if (root.left != null && root.left.color == 'R') this.rr = true;
                    else if (root.right != null && root.right.color == 'R') this.lr = true;
                } else {
                    root.parent.right.color = 'B';
                    root.color = 'B';
                    if (root.parent != this.root) root.parent.color = 'R';
                }
            }
            f = false;
        }
        return root;
    }

    // Insert data into the tree
    public void insert(int data) {
        if (this.root == null) {
            this.root = new Node(data);
            this.root.color = 'B'; // Root is always black
        } else {
            this.root = insertHelp(this.root, data);
        }
    }

    // Inorder traversal helper function
    private void inorderTraversalHelper(Node node) {
        if (node != null) {
            inorderTraversalHelper(node.left);
            System.out.printf("%d ", node.data);
            inorderTraversalHelper(node.right);
        }
    }

    // Inorder traversal
    public void inorderTraversal() {
        inorderTraversalHelper(this.root);
    }

    // Print tree helper function
    private void printTreeHelper(Node root, int space) {
        if (root != null) {
            space += 10;
            printTreeHelper(root.right, space);
            System.out.printf("\n");
            for (int i = 10; i < space; i++) {
                System.out.printf(" ");
            }
            System.out.printf("%d\n", root.data);
            printTreeHelper(root.left, space);
        }
    }

    // Print the tree
    public void printTree() {
        printTreeHelper(this.root, 0);
    }

    public static void main(String[] args) {
        O1 t = new O1();
        int[] arr = {1, 4, 6, 3, 5, 7, 8, 2, 9};
        for (int i : arr) {
            t.insert(i);
            System.out.println();
            t.inorderTraversal();
        }
        t.printTree();
    }
}
 