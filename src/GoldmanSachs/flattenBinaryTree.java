package GoldmanSachs;

public class flattenBinaryTree {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }


    public static void flattenBT(Node node){

        Node prev = null;
        if(node == null)
            return;

        flattenBT(node.left);
        flattenBT(node.right);

        node.right = prev;
        node.left  = null;

        prev = node;

    }


    public static void main(String[] args) {

        Node node = new Node(2);
        node.left = new Node(3);
        node.right = new Node(7);
        node.left.left = new Node(8);
        node.left.right = new Node(1);
        node.right.left = new Node(6);
        node.right.right = new Node(0);

    }
}
