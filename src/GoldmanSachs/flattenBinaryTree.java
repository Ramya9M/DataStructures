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

       Node curr = node;

       while(curr != null){
           if(curr.left != null){
               Node prev = curr.left;

               while(curr.right != null)
                   prev = curr.right;

               prev.right = curr.right;
               curr.right = curr.left;
               curr.left = null;
           }
           curr = curr.right;
       }

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
