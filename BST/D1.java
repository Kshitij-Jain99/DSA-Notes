public class D1 {
    public static class BST { // Changed to static so it can be accessed in the static context of main
        static class Node {
            int data;
            Node left;
            Node right;

            Node(int data) {
                this.data = data;
            }
        }

        public static Node insert(Node root, int val) { // Insert node in BST and return Node-[root]
            if (root == null) {
                root = new Node(val);
                return root;
            }
            if (root.data > val) {
                // Left subtree
                root.left = insert(root.left, val);
            } else {
                // Right subtree
                root.right = insert(root.right, val);
            }
            return root;
        }

        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
        
        public static boolean search(Node root, int key) {
            if(root == null) {
                return false;
            }
    
            if(root.data == key){
                return true;
            }
    
            if(root.data > key) {
                return search(root.left, key);
            }
    
            else{
                return search(root.right, key);
            }
        }
    }

    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        BST.Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = BST.insert(root, values[i]);
        }

        BST.inorder(root);
        System.out.println();

        if(BST.search(root,6)) {
            System.out.println("found");
        } else{
            System.out.println("not found");
        }
    }
}
/*
 *you need to ensure the search method is accessible in the main method. Since the search method is inside the BST class,
  you should call it as BST.search(root, 1).
 */