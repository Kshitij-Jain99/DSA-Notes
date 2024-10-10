public class N1 {
 static class Node{
    int data, height;  //height is used to find out balanced factor
    Node left, right;

    Node(int data) {
        this.data = data;;
        height = 1;
    }
 }   

public static Node root;

public static int height(Node root) {
    if(root == null) 
        return 0;

    return root.height; //stored height in node
}

//Right rotate subtreee ootes with y
public static Node rightRotate(Node y) {
    Node x = y.left;
    Node T2 = x.right;

    //rotation using 3 nodes
    x.right = y;
    y.left = T2;

    //update heights
    y.height = Math.max(height(y.left), height(y.right)) + 1;
    x.height = Math.max(height(x.left), height(x.right)) + 1;

    //x is new root
    return x;

}

//left rotate subtree rootes with x
public static Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;

    //rotation using 3 nodes
    y.left = x;
    x.right = T2;

    //update heights
    x.height = Math.max(height(x.left), height(x.right))+ 1;
    y.height = Math.max(height(y.left), height(y.right)) +1;

    //y is new root
    return y;

}

//Get balance factor of node
public static int getBalance(Node root) {
    if(root == null)
        return 0;

    return height(root.left) - height(root.right);
}

public static Node insert(Node root, int key) {
    if(root == null)
        return new Node(key);

    if(key< root.data) 
        root.left = insert(root.left, key);
    else if(key> root.data)
        root.right = insert(root.right, key);
    else
        return root;     //Duplicates keys not allowed
    
    //update root height
    root.height = 1+ Math.max(height(root.left), height(root.right));

    //Get root's balance factor
    int bf = getBalance(root);

    //Left left case
    if(bf >1 && key< root.left.data)
        return rightRotate(root);

    //Right Right case
    if(bf < -1 && key > root.right.data)
        return leftRotate(root);

    //Left Right case
    if(bf > 1 && key > root.left.data) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }

    //Right Left case
    if(bf <-1 && key < root.right.data) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }

       return root;   //returned if AVL balanced
    }

    public static void preorder(Node root) {
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 25);
        root = insert(root, 22);
       

          preorder(root);
    }
}
