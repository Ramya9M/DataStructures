package Trees.traversals;

import java.util.*;
public class VerticalOrder {


//    class Node {
//        TreeNode node;
//        int hd;
//
//        Node(TreeNode node, int hd) {
//            this.node = node;
//            this.hd = hd;
//        }
//    }
//    public  ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
//
//        Queue<Node> q = new LinkedList<>();
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//        HashMap<Integer, List<Integer>> hm = new HashMap<>();
//
//        q.add(new Node(A,0));
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//
//        while(!q.isEmpty()){
//            List<Integer> list = new ArrayList<>();
//            Node temp = q.poll();
//            TreeNode temp1 = temp.node;
//            int d = temp.hd;
//
//            if(hm.containsKey(d)) {
//                list =  hm.get(d);
//                list.add(temp1.data);
//                hm.put(d, list);
//            }
//            else {
//                min = d<min? d:min;
//                max = d>max? d:max;
//                list.add(temp1.data);
//                hm.put(d, list);
//            }
//            if(temp1.left != null)
//                q.add(new Node(temp1.left, d-1));
//            if(temp1.right != null)
//                q.add(new Node(temp1.right, d+1));
//        }
//
//        for(int i=min; i<=max; i++){
//
//            ans.add((ArrayList<Integer>) hm.get(i));
//        }
//
//        return null;
//    }

     int res = 1;


    private int isBalancedHelper(TreeNode A){

        if(A == null)
            return -1;

        int l =  isBalancedHelper(A.left);
        int r =  isBalancedHelper(A.right);

        if(Math.abs(l-r)>1)
            res = 0;

        return  1+Math.max(l,r);
    }

    public int isBalanced(TreeNode A) {

        isBalancedHelper(A);
        return res;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(9);
        root.right = new TreeNode(4);

        root.right.left = new TreeNode(8);
        root.right.left.right = new TreeNode(3);
        VerticalOrder vo = new VerticalOrder();
        System.out.println(vo.isBalanced(root));
    }
}

