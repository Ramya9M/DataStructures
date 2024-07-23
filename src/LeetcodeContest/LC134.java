package LeetcodeContest;

import java.util.*;

public class LC134 {

    public static int numberOfAlternatingGroups(int[] colors) {

        int n = colors.length;
        int m = n;

        int i = 0;
        int j = 2;
        int count = 0;
        while(m>0){
            int temp = 0;
            if(i!=n-1) {
                temp = colors[i + 1];
            }else{
                temp = colors[j-1];
            }
            if(temp != colors[i] && temp!= colors[j])
                count++;
            if(i==n-1 && j<n){
                i = 0;
                j = j+1;
            }
            if(j==n-1 && i<n){
                j = 0;
                i = i+1;
            }
            else{
                i = i+1;
                j = j+1;
            }
            m--;
        }
        return count;
    }

    public static long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        Arrays.sort(enemyEnergies);
        int n = enemyEnergies.length;
        int points = 0;
        for(int i=0; i<n; i++)
            deque.add(enemyEnergies[i]);

        while(deque.size()>0){
            int first = deque.getFirst();
            if(currentEnergy >= first){
                currentEnergy -= first;
                points++;
            }
            if(points>=1){
                int last = deque.removeLast();
                currentEnergy += last;
            }
            if(points<0 && deque.getFirst() > currentEnergy)
                break;
        }
        return points;
    }

    static int countStrings(int n)
    {
        int a = 0;
        int b = 0;
        for (int i = 1; i < n; i++) {
            // Here we have used the temp variable because
            // we want to assign the older value of a to b
            int temp = a + b;
            b = a;
            a = temp;
        }
        return (a + b)%1000000007;
    }
    /* Driver program to test above function */
    public static void main(String args[])
    {
        System.out.println(countStrings(3));
    }
//    public static void main(String args[]){
//
//        int[] enemyEnergies = new int[]{2};
//        int currentEnergy = 10;
//        System.out.println(maximumPoints(enemyEnergies, currentEnergy));
//    }
}
