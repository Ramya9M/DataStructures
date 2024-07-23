package Arrays;

import java.util.*;

public class MaxSubSeqWithGivenCondV2 {

    //int[] a = new int[]{1,3,3,5,6,8};
    public static int findMaxSubSeq(int[] a){

        SortedMap<Integer, Integer> sortedMap = new TreeMap<>();

        int n = a.length;
        int[] freq = new int[1000000000];

        for(int i=0; i<n; i++)
            freq[a[i]]++;

        Set s = sortedMap.entrySet();
        Iterator it = s.iterator();

        for(int i=0; i<n; i++){

            int backValue = 0;

            int dp = Math.max(sortedMap.get(a[i-1]), (a[i] * freq[a[i]]) + backValue);
            sortedMap.put(a[i],dp);
        }
        return  0;
    }

    public static void main(String args[]){

        int[] a = new int[]{1,3,3,5,6,8};
        findMaxSubSeq(a);
    }
}
