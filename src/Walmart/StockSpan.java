package Walmart;

import java.util.*;
public class StockSpan {

    public static void stockSpan(int[] a){

        Stack<Integer> s = new Stack<>();
        s.push(0);
        int[] span = new int[a.length];

        for(int i=1; i<a.length; i++){

            while(!s.isEmpty() &&  a[s.peek()]<=a[i]){
                s.pop();
            }
            if(s.isEmpty())
                span[i] = i+1;
            else
                span[i] = i-s.peek();

            s.push(i);
        }

        for(int i : span)
            System.out.println(i);
    }

    public static void main(String[] args) {

        int[] a = new int[]{100,80,60,70,60,75,85};
        stockSpan(a);
    }
}
