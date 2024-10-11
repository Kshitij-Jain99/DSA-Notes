public class I1 {

    static class Node {
        int data;
        Node left, right;

        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
       //check rest subtree with tree
        public static boolean isIdentical(Node node, Node subRoot) {
            if(node == null && subRoot == null){
                return true;
            } else if(node == null || subRoot == null || node.data != subRoot.data) {// dono mein sein ek null ya dono ka data unequal
                return false;
            }

            if(!isIdentical(node.left, subRoot.left)){
                return false;
            }
            if(!isIdentical(node.right, subRoot.right)){
                return false;
            }
            return true;
        }
    
        //to check where does subroot lies in main tree
        public static boolean isSubtree(Node root, Node subRoot){
            if(root == null) {
                return false;
            }
              /*
               *1.root == subroot check
                2.left subtree mein subroot check
                3.right subtree mein subroot check
               */
            if(root.data == subRoot.data) {
                if(isIdentical(root, subRoot)) {
                    return true;
                }
            }

            // boolean leftAns = isSubtree(root.left, subRoot);  //lsubtree -> true
            // boolean rightAns = isSubtree(root.right, subRoot);

            // return leftAns || rightAns; 
               return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);  //This is much better form, the second call will not execute if  even if one of these 2 return true, OR operator

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
            root.right.right= new Node(7);

            /*
                           2
                          / \
                         4   5
             */
            Node subRoot = new Node(2);
            subRoot.left = new Node(4);
            subRoot.right = new Node(5);
            
            System.out.println(isSubtree(root, subRoot)); 
    }
}

