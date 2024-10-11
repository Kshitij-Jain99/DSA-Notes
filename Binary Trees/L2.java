//Least Common Ancestor in Binary Tree->Approach 2:: TC=O(n)
// Direct approach to finding the Least Common Ancestor (LCA)

public class L2 {

    static class Node {
        int data;
        Node left, right;

        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static Node lca2(Node root, int n1, int n2){
        // if(root == null) {
        //     return null;
        // }
        if(root == null || root.data == n1 || root.data == n2){ //both n1, n2 together
            return root;
        }
        //If Allowing a node to be a descendant of itself: this behavior is already implicitly handled by the base case
       
        //Recursive search on right and left subtree
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        //leftLCA = val  rightLca = null
        if(rightLca == null) {
            return leftLca;
        }
        if(leftLca == null) {
            return rightLca;
        }

        return root;
    }

       
    public static void main(String args[]) {
        /*
               1
              / \
             2   3
            / \ / \ 
            4 5 6  7    
         */
        Node root = new Node(1); 
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 =6;
        System.out.println(lca2(root, n1, n2).data);    //.data if not used then we get node address

    }
}
