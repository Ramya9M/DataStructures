package Leetccode;

public class MaxSubSeqNonAd {

    public static int maximumSumSubsequence(int[] nums, int[][] queries) {

        int r = queries.length;
        int c = queries[0].length;
        int ans = 0;
        int sum1 = 0;
        for(int i=0,j=0; i<r; i++){
            nums[queries[i][j]] = queries[i][j+1];
            if(nums[0]>0)
             sum1 = nums[0];
            int sum2 = 0;
            for(int k=1; k<nums.length; k++){
                int temp = sum1;
                sum1 = Math.max(sum1, sum2+nums[k]);
                sum2 = temp;
            }
            ans += sum1;
            sum1=0;
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String args[]){
        int[] nums = new int[]{3,-2,9};
        int[][] que = new int[][]{{1,-2},{0,-3}};
        maximumSumSubsequence(nums,que);
    }
}
