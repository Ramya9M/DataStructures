package Walmart;

import java.util.*;

public class KLargest {

    public static void kLargestEle(int[] a, int k){

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0; i<a.length; i++){

            pq.add(a[i]);
            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{99,14,10,20,15};
        kLargestEle(nums,3);

    }
}
