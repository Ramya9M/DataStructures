package Trees;

public class heightOfTree {

    public static int maxHeight(Node root){

        if(root == null)
            return 0;

        int lh = maxHeight(root.left);
        int rh = maxHeight(root.right);

        return 1+Math.max(lh, rh);
    }

    public static void main(String args[]){

        Node root = new Node(4);
        root.left = new Node(3);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(10);
        root.right.left.left = new Node(11);
        root.right.left.left.left = new Node(78);

        System.out.println(maxHeight(root));
    }
}
