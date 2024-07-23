package LeetcodeContest;

import java.util.*;
public class LC406 {

    static String swap(String str, int i, int j)
    {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    static boolean isSameParity(char ch1, char ch2){
        int a = ch1 - '0';
        int b = ch2 - '0';

        if( (a%2 == 0) && (b%2 == 0))
            return true;
        else if((a%2 != 0)&&(b%2 != 0))
            return true;
        else
            return false;
    }
    public static String getSmallestString(String s) {

            String t = s;
            List<String> ans = new ArrayList<>();
            ans.add(t);
            int n = s.length();
            for(int i=1; i<n; i++){
                if(isSameParity(s.charAt(i-1), s.charAt(i))){
                    int a = s.charAt(i-1) - '0';
                    int b = s.charAt(i) - '0';
                    s = swap(s, i-1, i);
                }
                ans.add(s);
                s = t;
            }
            String res = ans.get(0);
            int j =0;
            for(String i : ans){
                if(i.compareTo(res) < 0)
                    res = i;
            }

            return res;
    }

    public static class ListNode {

      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode modifiedList(int[] nums, ListNode head) {

        ListNode prev = null;

        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums)
            set.add(i);

        ListNode curr = head;
        while(curr != null){

            if(set.contains(curr.val)){
                if(prev == null) {
                    head = curr.next;
                    prev = head;
                    curr = curr.next;
                }
                else{

                    prev = curr;
                    head = head.next;
                    curr = curr.next;
                }
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static ListNode convertToLL(int[] a){

        ListNode head = new ListNode(a[0]);
        ListNode mover = head;

        for(int i=1; i<a.length; i++){
            ListNode temp = new ListNode(a[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    public static int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {

        int[][] dp = new int[m+1][n+1];

        dp[0][0] = 0;
        for(int i=1; i<m; i++)
            dp[i][0]  =  dp[i-1][0]  + horizontalCut[i-1];

        for(int i = 1; i<n; i++)
            dp[0][i] = dp[0][i-1] +  verticalCut[i-1];

        for(int i=1; i<m; i++){
            for(int j = 1; j<n ; j++){
                int res = dp[i][j-1] + dp[i-1][j];
                dp[i][j] = Math.min(res+horizontalCut[i-1], res+verticalCut[j-1]);
            }
        }
        for(int i=0; i<m ;i++)
            for(int j =0; j<n; j++)
                System.out.println(dp[i][j]);
            System.out.println();
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
//        String s = "45320";
//        System.out.println(getSmallestString(s));

//        int[] nums = new int[]{1,2,3};
//        int[] input = new int[]{1,2,3,4,5};
//        ListNode head =  convertToLL(input);
//        ListNode res = modifiedList(nums, head);
//
//        while(res != null) {
//            System.out.println(res.val);
//            res = res.next;
//        }

        int[] h = new int[]{1,3};
        int[] v = new int[]{5};
        System.out.println(minimumCost(3,2,h,v));
    }
}
