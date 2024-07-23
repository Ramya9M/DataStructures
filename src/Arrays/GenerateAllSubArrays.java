package Arrays;

import java.util.*;
public class GenerateAllSubArrays {


    public static List<List<Integer>> generateAll(int[] a){

        int n = a.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            List<Integer> list = new ArrayList<>();
            for(int j=i; j<n; j++){
                for(int k = i; k<=j; k++)
                    System.out.print(a[k]+ " ");
                System.out.println();
            }

        }

        return ans;
    }

    public static int numberOfSubarrays(int[] nums, int k) {

        int n = nums.length;
        int[] prebit = new int[n];

        if((nums[0] & (1<<0))==1){
            prebit[0] = 1;
        }
        else{
            prebit[0] = 0;
        }

        for(int i=1; i<n; i++){
            if((nums[i] & (1<<0))==1)
                prebit[i] = prebit[i-1]+1;
            else
                prebit[i] = prebit[i-1];
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            int temp = 0;
            for(int j=i; j<n; j++){
                if(i==0)
                    temp = prebit[j];
                else{
                    temp = prebit[j] - prebit[i-1];
                }
                if(temp == k)
                    cnt++;
            }
        }
        System.out.println(cnt);
        return cnt;
    }
    public static void main(String args[]){
        int[] arr = new int[]{1,1,2,1,1};
        numberOfSubarrays(arr,3);
    }
}
