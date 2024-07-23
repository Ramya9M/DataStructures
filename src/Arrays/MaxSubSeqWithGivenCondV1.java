package Arrays;


/*
* find the maximum subsequence of the array, provided,
*  if ur taking the ith element you cannot take i-1 th and i-2 th elemnet
* */
public class MaxSubSeqWithGivenCondV1 {

    public static int findMaxSubSeq(int[] a){

        int n = a.length;
        int[] dp = new int[n];

        for(int i=1; i<n; i++){

            if(i-3 < 0)
                dp[i] = a[i];
            else{
                dp[i] = Math.max( a[i]+dp[i-3], dp[i-1]);
                dp[i] = Math.max( dp[i], dp[i-2]);
            }
        }
        System.out.println(dp[n-1]);
        return dp[n-1];
    }

    public static void main(String args[]){

        int[] a = new int[]{1,1,3,4,5,6};
        findMaxSubSeq(a);
    }

}
