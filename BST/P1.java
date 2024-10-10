//Lowest Common Ancestor of BST-> Most optimized approach
public class P1 {
    static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode (int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if ((root == p || root == q) || (root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)) {
                return root;
            }
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }
        }
        return null; // Return null if no ancestor found
    }


// Main function to demonstrate BST and LCA

    public static void main(String[] args) {
        // Create a simple BST
        /*
       6
      / \
     2   8
    / \ / \
   0  4 7  9
     / \
    3   5
*/

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        // Create instances of nodes for which we want to find the LCA
        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.left.right; // Node with value 4

        // Instantiate the Solution class and find the LCA
       
        TreeNode lca = lowestCommonAncestor(root, p, q);
            System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
       
    }
}
