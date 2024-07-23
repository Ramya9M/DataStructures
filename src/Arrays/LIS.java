package Arrays;

import java.util.*;
public class LIS {

    public static int lengthOfLongestSubsequence(int[] arr){

        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++) {
                if(arr[i]>arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max = 0;

        for(int i=0; i<n; i++)
            max = max<dp[i] ? dp[i] : max;

        System.out.println(max);
        return max;
    }

    public static void main(String args[]) {
            int[] arr = new int[]{0,4,12,2,10,6,9,13,3,11,7,15};
        lengthOfLongestSubsequence(arr);
    }
}
