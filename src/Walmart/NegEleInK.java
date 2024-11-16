package Walmart;

import java.util.*;
public class NegEleInK {

    public static void negEleInK(int[] a, int k){

        Queue<Integer> q = new LinkedList<>();
        int i=0, j=0;
        int n = a.length;
        int[] res = new int[n-k+1];
        int idx = 0;

        while(j<n){

            if(a[j]<0)
                q.add(a[j]);

            if(j-i+1 == k){

                if(q.isEmpty()==true)
                    res[idx++] = 0;

                else {

                    res[idx++] = q.peek();
                    if (a[i] == q.peek())
                        q.poll();

                    i++;
                }
            }
            j++;
        }

        for(int l : res)
            System.out.println(l);

    }

    public static void main(String[] args) {

        int[] a = new int[]{12,-1,-7,8,-15,30,16,28};
        negEleInK(a,3);
    }
}
