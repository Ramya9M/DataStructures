package Walmart;

public class MaxSumWithOutAdj {

    public static int maxSum(int[] a){

        int sum1 = 0;
        int sum2 = 0;
        int temp = 0;
        int max = 0;

        int n = a.length;

        for(int i=0; i<n; i++){

         //   max = Math.max(sum1,sum2);
            temp = sum2;
            sum2 = sum1;
            sum1 = Math.max(temp+a[i],sum1);
        }


        return sum1;
    }

    public static void main(String[] args) {

        int[] a = new int[]{0,1,2,0,1,2};
        System.out.println(maxSum(a));
    }
}
