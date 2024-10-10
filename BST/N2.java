public class N2 {
    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1; // New node is initially added at leaf
        }
    }

    public static Node root;

    // Utility function to get the height of the node
    public static int height(Node root) {
        if (root == null)
            return 0;
        return root.height;
    }

    // Function to right rotate subtree rooted with y
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Function to left rotate subtree rooted with x
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get balance factor of node
    public static int getBalance(Node root) {
        if (root == null)
            return 0;
        return height(root.left) - height(root.right);
    }

    // Utility function to get the node with the minimum value found in that tree
    public static Node getMinNode(Node root) {
        Node curr = root;
        // Loop down to find the leftmost leaf
        while (curr.left != null)
            curr = curr.left;
        return curr;
    }

    // Recursive function to delete a node with given key from subtree with given root
    // It returns root of the modified subtree
    public static Node deleteNode(Node root, int key) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;

        // If the key to be deleted is smaller than the root's key, then it lies in left subtree
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        }
        // If the key to be deleted is greater than the root's key, then it lies in right subtree
        else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        }
        // If key is same as root's key, then this is the node to be deleted
        else {
            // Node with only one child or no child
            if (root.left == null || root.right == null) {
                Node temp = (root.left != null) ? root.left : root.right;

                // No child case
                if (temp == null) {
                    root = null;
                } else { // One child case
                    root = temp; // Copy the contents of the non-empty child
                }
            } else {
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                Node temp = getMinNode(root.right);

                // Copy the inorder successor's data to this node
                root.data = temp.data;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.data);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether this node became unbalanced)
        int bf = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (bf > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (bf > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (bf < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (bf < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Utility function to perform preorder traversal of the tree
    public static void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        // Example AVL tree setup
        root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(30);
        root.right.right.left = new Node(25);

        // Ensure correct height and balance factors for the example tree
        updateHeightAndBalance(root);

        // Preorder traversal before deletion
        System.out.print("Preorder before deletion: ");
        preorder(root);
        System.out.println();

        // Delete a node with value 20
        root = deleteNode(root, 20);

        // Preorder traversal after deletion
        System.out.print("Preorder after deletion: ");
        preorder(root);
    }

    // Helper function to update the height of nodes in the AVL tree
    public static void updateHeightAndBalance(Node node) {
        if (node == null) return;
        updateHeightAndBalance(node.left);
        updateHeightAndBalance(node.right);
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }
}
