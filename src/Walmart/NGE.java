package Walmart;

import java.util.*;
public class NGE {

    public static void nge(int[] a){

        Stack<Integer> s = new Stack<>();
        int n = a.length;
        int[] res = new int[n];

        s.add(0);

        for(int i=1; i<n; i++){

            if(a[i]<=a[s.peek()])
                s.add(i);
            else{
                while(a[s.peek()]<=a[i]){
                    res[s.peek()] = a[i];
                    s.pop();
                }
                s.add(i);
            }
        }
        while(!s.isEmpty()){
            res[s.peek()] = -1;
            s.pop();
        }

        for(int i : res)
            System.out.println(i);
    }

    public static void main(String[] args) {

        int a[] = new int[]{13,7,6,12,10};
        nge(a);
    }
}
