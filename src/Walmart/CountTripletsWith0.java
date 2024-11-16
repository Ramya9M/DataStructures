package Walmart;

import java.util.*;
public class CountTripletsWith0 {

    public static boolean findTriplets(int[] a){

        Arrays.sort(a);
        int n = a.length;

        for(int i=0; i<n; i++){
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = a[i] + a[j] + a[k];
                if(sum == 0)
                    return true;
                else if(sum < 0)
                    j++;
                else if(sum > 0)
                    k--;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        int[] a = new int[]{-3, -1, 0, 1,5 };
        System.out.println(findTriplets(a));
    }
}
