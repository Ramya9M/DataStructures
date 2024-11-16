package LeetcodeContest;

import java.lang.reflect.Array;
import java.util.*;
public class LC135 {

    public static String losingPlayer(int x, int y) {

        int sum = (75*x) + (10*y);
        int times = sum/115;
        if(times%2 == 0)
            return "Bob";
        else
            return "Alice";
    }

    public static int minimumLength(String s) {

        int n = s.length();
        int prevInd = -1;
        int postInd = -1;
        String ans = "";
        int count = 0;

        for(int i=1; i<n-1; i++){

            String prev = s.substring(0,i);
            String next = s.substring(i+1,n);

            prevInd = prev.indexOf(s.charAt(i));
            postInd = next.indexOf(s.charAt(i));
            if(postInd>=0)
                postInd += + (prev.length()+1);

            if(prevInd>=0 && postInd>=0){
              ans += s.substring(0,prevInd);
              ans += s.substring(prevInd+1,i+1);
              ans += s.substring(i+1, postInd);
              ans += s.substring(postInd+1,n);
              count++;
              s = ans;
            }
            ans = "";
            n = s.length();
        }
        System.out.println(s.length());
        return count;
    }

    public static int minimumLengthapproach2(String s){

        HashMap<Character,Integer> hm = new HashMap<Character, Integer>();

        for(int i=0; i<s.length(); i++){
            if(hm.containsKey(s.charAt(i)))
                hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
            else
                hm.put(s.charAt(i),1);
        }

        int res = 0;
        for(Map.Entry<Character,Integer> map : hm.entrySet()) {
            if(map.getValue()>=3)
              res += map.getValue()/2;
            else
              res += map.getValue();
        }

        System.out.println(res);
        return res;
    }


    public static int minChanges(int[] nums, int k) {

        int n = nums.length;
        int totalPair = n/2;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<n/2; i++){
            int diff = Math.abs(nums[i]-nums[n-i-1]);
            if(hm.containsKey(diff))
                hm.put(diff, hm.get(diff)+1);
            else
                hm.put(diff,1);
        }

        HashMap<Integer, Integer> hmMax = new HashMap<>();

        for(int i=0; i<n/2; i++){

            int max = Math.max(nums[i], nums[n-i-1]);
            int min = Math.min(nums[i], nums[n-i-1]);
            int res = Math.max(Math.abs(0-max),Math.abs(min-k));

            if(hmMax.containsKey(res))
                hmMax.put(res, hmMax.get(res)+1);
            else
                hmMax.put(res,1);
        }

        int[] diffArray = new int[k+1];
        Arrays.fill(diffArray,0);

        for(Map.Entry<Integer, Integer> entry : hmMax.entrySet()){
            diffArray[entry.getKey()] = entry.getValue();
        }

        for(int i=k-1; i>=0; i--)
            diffArray[i] = diffArray[i+1]+diffArray[i];

        int ans = Integer.MAX_VALUE;

        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            int temp = (diffArray[entry.getKey()] - entry.getValue());
            temp = (temp*1) + ((totalPair-temp)*2);
            if(ans>temp)
                ans = temp;
        }
        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) {
//        int x = 4 ;
//        int y = 11;
//        losingPlayer(x,y);

//        String s = "abaacbcbb";
//        minimumLengthapproach2(s);

        int[] nums = new int[]{1,1,1,1,0,0,0,5,4,3,19,17,16,15,15,15,19,19,19,19};
        minChanges(nums,20);

    }
}
