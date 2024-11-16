package Walmart;

import java.util.*;
public class MinJumps {


    public static int minJumps(int[] arr){

        int n = arr.length;
        int[] min = new int[n];

        Arrays.fill(min,Integer.MAX_VALUE);

        min[0] = 0;


        for(int j=1; j<n; j++){

            for(int i=0; i<j; i++){

                if(arr[i]>=(j-i)){
                    min[j] = Math.min(min[j],min[i]+1);
                }
            }
        }

        for(int i : min)
            System.out.print(i + " ") ;

        System.out.println();

        return min[n-1];

    }
    public static void main(String[] args) {


        int[] arr = new int[]{2,3,1,1,2,4,2,0,1,1};
        System.out.println(minJumps(arr));

    }
}
