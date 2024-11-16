package Walmart;


class TreeNode{

    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
public class isSumTree {

    public static int add(TreeNode node){

        if(node == null)
            return 0;

        return add(node.left) + node.data + add(node.right);
    }

    public static int isSumTree(TreeNode root){

        if(root == null)
            return 1;

        if(root.left!=null && root.right!= null)
            return 1;

        int left = add(root.left);
        int right = add(root.right);

        int total = left + right;

        if(total == root.data){

            if(isSumTree(root.left)==1 && isSumTree(root.right)==1)
              return 1;

            return 0;

        }
        return 0;
    }
}
