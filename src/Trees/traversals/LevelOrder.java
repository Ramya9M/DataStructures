package Trees.traversals;

import java.util.*;

public  class LevelOrder {

    static  void  levelOrder(TreeNode root){

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> ans = new LinkedList<>();

        while(!q.isEmpty()){
            List<Integer> sub = new ArrayList<>();
            int levelSize = q.size();
            for(int i=0; i<levelSize; i++){
                if(q.peek().left!=null)
                    q.offer(q.peek().left);
                if(q.peek().right!=null)
                    q.offer(q.peek().right);

                sub.add(q.poll().data);
            }
            ans.add(sub);
        }

        for(List<Integer> i : ans){
            for(Integer j : i){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(8);
        levelOrder(root);
    }

}
