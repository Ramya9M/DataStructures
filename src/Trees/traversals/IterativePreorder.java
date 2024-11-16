package Trees.traversals;

import com.sun.source.tree.Tree;

import java.util.*;
public class IterativePreorder {

    public static void pre(TreeNode root){

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){

            TreeNode temp = st.pop();
            ans.add(temp.data);
            if(temp.right!=null)
                st.push(temp.right);
            if(temp.left != null)
                st.push(temp.left);
        }
       for(int i : ans)
           System.out.print(" "+ i + " " );
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        pre(root);
    }
}
