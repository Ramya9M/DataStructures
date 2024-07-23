package Arrays;

import java.math.BigInteger;

import static java.lang.Math.pow;

public class GenerateAllSubSequences {

    public static void printSubSeq(int[] arr){

        int n = arr.length;

        for(int i=1; i<pow(2,n); i++){

            for(int j=0; j<n; j++){

                if(BigInteger.valueOf(i).testBit(j))
                    System.out.println(arr[i]);
            }
            System.out.println(" ");
        }
    }

    public static void main(String args[]){

        int[] arr = new int[]{1,2,3,4};
        printSubSeq(arr);

    }
}
