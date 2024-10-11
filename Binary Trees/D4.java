//levelorder traverse
import java.util.*;

public class D4 {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data) {   //Constructor->data
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static class BinaryTree{
        static int idx = -1;   //taken static because we want to update it at each level
        public static Node buildTree(int nodes[]) {    //We return Node[root] of tree
           idx++;  //index gets 0 at first call
           if(nodes[idx] == -1) {
            return null;
           }

           Node newNode = new Node (nodes[idx]);
           newNode.left = buildTree(nodes);   //assuming build tree is recusive fxn to kam[left subtree banana] to karke de hi dega usko "=" ki help sein jod denge
           newNode.right = buildTree(nodes);

           return newNode;
        }
  //added
        public static void levelorder(Node root) {
            if(root == null) {
                return  ;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()) {
                Node currNode = q.remove();
                if(currNode == null) {
                    System.out.println();
                    if(q.isEmpty()) {
                        break;
                    } else{
                        q.add(null);
                    }
                }
                    else{
                        System.out.print(currNode.data +" ");
                        if(currNode.left != null) {
                            q.add(currNode.left);
                        }    
                        
                        }
                        if(currNode.right != null) {
                            q.add(currNode.right);
                        }

                    }
                }
            }

        
    

    public static void main(String args[]) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        
        tree.levelorder(root);
    }
}
