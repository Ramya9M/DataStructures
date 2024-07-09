package GoldmanSachs;

public class trappingRainwater {


    public static int maxStorage(int[] arr){

        int n = arr.length;
        int[] leftMax  = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = arr[0];
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1],arr[i]);
        }

        rightMax[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1],arr[i]);
        }

        int maxSum = 0;

        for(int i=0; i<n; i++){
            int temp = Math.min(leftMax[i],rightMax[i])-arr[i];
            maxSum += temp;
        }
        System.out.println(maxSum);
        return maxSum;
    }


    public static void main(String[] args) {

        int[] arr = new int[]{4,2,0,3,2,5};
        maxStorage(arr);

    }
}
