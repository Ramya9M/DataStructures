package Trees;

public class MaxDepthBT {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(){}
        Node(int data){
            this.data = data;
            this.left=this.right=null;
        }
    }


    public int maxDepth(Node root){

        if (root == null)
            return  0;
        else{
            int lDepth = maxDepth(root.left);
            int rDepth = maxDepth(root.right);

            if(lDepth>rDepth)
                return lDepth + 1;
            else
                return rDepth +1;
        }
    }
    public static void main(String[] args) {

        MaxDepthBT maxDepthBT = new MaxDepthBT();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        System.out.println(maxDepthBT.maxDepth(root));
    }
}
