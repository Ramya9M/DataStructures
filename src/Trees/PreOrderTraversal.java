package Trees;

/*
*   preorder traversal is root, left, right
* */

class Node{

    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class PreOrderTraversal {


    public static void preOrder(Node root){

        if(root==null)
            return;

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String args[]){

       Node root = new Node(4);
       root.left = new Node(3);
       root.right = new Node(2);
       root.left.left = new Node(1);
       root.left.right = new Node(7);
       root.right.left = new Node(9);
       root.right.right = new Node(10);

       preOrder(root);

    }
}
