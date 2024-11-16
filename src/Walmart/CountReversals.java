package Walmart;

import java.util.*;
public class CountReversals {

    public static int countReversal(String s){

        int n = s.length();
        if(n==0)
            return -1;
        if(n%2 != 0)
            return -1;

        int count = 0;

        Stack<Character> st = new Stack<Character>();

        for(char c : s.toCharArray()){

            if(c == '{')
                st.push(c);
            else {
                if (st.isEmpty() == true) {
                    count++;
                    st.push('{');
                } else {
                    st.pop();
                }
            }
        }
        count += (st.size()/2);
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {

        countReversal("{{{{}}");

    }
}
