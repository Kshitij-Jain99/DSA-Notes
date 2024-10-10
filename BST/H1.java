public class H1 {
    public static class BST {
        static class Node {
            int data;
            Node left;
            Node right;

            Node(int data) {
                this.data = data;
            }
        }

        public static Node insert(Node root, int val) {
            if (root == null) {
                root = new Node(val);
                return root;
            }
            if (root.data > val) {
                root.left = insert(root.left, val);
            } else {
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
       
        public static boolean isValidBST(Node root, Node min, Node max) {
            if(root == null) {   //no node BST is valid
                return true;
            }

            if(min != null && root.data <= min.data) {
                return false;
            }

            else if(max != null && root.data >= max.data){
                return false;
            }
            //if current node satify both above conditions then we analyze all nodes of left and right subtree
            return isValidBST(root.left, min, root) 
            && isValidBST(root.right, root, max);
        }
   }
   public static void main(String[] args) {
    int values[] = {1,1,1};
    BST.Node root = null;

    for (int i = 0; i < values.length; i++) {
        root = BST.insert(root, values[i]);
    }

    BST.inorder(root);
    System.out.println();
    
    if(BST.isValidBST(root,null,null)){
        System.out.println("valid");
    } else{
        System.out.println("not valid");
        }
    }
}
