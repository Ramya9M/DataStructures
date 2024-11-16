package Trees.traversals;

import java.util.*;
public class IterativeInordre {

    public static void inorder(TreeNode root){

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(true){

            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()==true){
                    break;
                }
                node = st.pop();
                ans.add(node.data);
                node = node.right;
            }
        }
        for(int i : ans)
            System.out.println(i);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        inorder(root);
    }
}
