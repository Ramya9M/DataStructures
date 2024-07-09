package GoldmanSachs;

public class BstOrnOT {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static boolean isBST(Node node){
         return  bstUtil(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    static boolean bstUtil(Node node,int min, int max){

        if(node == null)
            return true;

        if(node.data < min || node.data > max)
            return false;

        return (bstUtil(node.left,min, node.data-1) &&
               bstUtil(node.right, node.data+1, max));
    }

    public static void main(String[] args) {

        Node node = new Node(4);
        node.left = new Node(2);
        node.right = new Node(5);
        node.left.left = new Node(1);
        node.left.right = new Node(3);

        System.out.println(isBST(node));

    }
}
