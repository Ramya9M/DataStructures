package GoldmanSachs;

public class largestContiguousSum {

    //-2,3,4,-1,-2,1,5,-3
    public static int  findLargestSum(int[] arr){

        int n = arr.length;

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){

        sum += arr[i];
        max = sum>max? sum : max;
        sum = sum < 0 ? 0 : sum;

        }
        return max;
    }

    public static void main(String args[]){

        int arr[] = new int[]{-2,-3,4,-1,-2,1,5,-3};
        System.out.println(findLargestSum(arr));
    }
}
