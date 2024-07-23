package LeetcodeContest;

import java.util.*;

import java.util.stream.Collectors;
public class LC402 {

    public static long maximumTotalDamage(int[] power) {

        int n = power.length;

        List<Integer> inp = new ArrayList<>();

        for(int i=0; i<n; i++)
            inp.add(power[i]);

        Map<Integer, Integer>  freq = new HashMap<>();

        for(int i=0; i<n; i++){
            int y = power[i];
            if(freq.containsKey(y))
                freq.put(y, freq.get(y)+1);
            else
                freq.put(y,1);

            if(!freq.containsKey(y-1))
               freq.put(y-1,0);
            if(!freq.containsKey(y-2))
               freq.put(y-2,0);
        }

        List<Integer> mp = new ArrayList<>();

        for(int i=0; i<n; i++){
            mp.add(power[i]);
            mp.add(power[i]-1);
            mp.add(power[i]-2);
        }

        int[] a = new int[mp.size()];

        for(int i=0; i<mp.size(); i++)
            a[i] = mp.get(i);

        Arrays.sort(a);

        int[] arr = new int[mp.size()];

        int j=0;

        for(int i=0; i<mp.size(); i++){
            if(i==0)
                arr[j++] = a[i];
            else if(a[i]!=a[i-1])
                arr[j++] = a[i];
        }
//        List<Integer> unique = new ArrayList<>();
//
//        for(int i : mp){
//            if(!unique.contains(i))
//                unique.add(i);
//        }

//        int[] arr = new int[unique.size()];
//        for(int i=0; i<unique.size(); i++)
//            arr[i] = unique.get(i);
//
//        Arrays.sort(arr);

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                int tmp = 0;
//                if (arr[i] > arr[j]) {
//                    tmp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = tmp;
//                }
//            }
//        }

//        List<Integer> sortedList = unique.stream()
//                .sorted().collect(Collectors.toList());

        //Map<Integer, Integer> fmp = new HashMap<>();
//
//        for(int i=0; i<arr.length; i++){
//
//            if(inp.contains(arr[i]))
//                fmp.put(arr[i],freq.get(arr[i]));
//            else
//                fmp.put(arr[i],0);
//
//        }

        int m = arr.length;
        long[] dp = new long[m];
        //   dp[0] = fmp.get(inp.get(0));
        for(int i=0;i<m;i++) {
            dp[i] =    freq.get(arr[i])*arr[i];
            if(i>=3)   dp[i] = Math.max(dp[i], dp[i] + dp[i-3]);
            if(i>=2)   dp[i] = Math.max(dp[i], dp[i-2]);
            if(i>=1)   dp[i] = Math.max(dp[i], dp[i-1]);
        }

         System.out.println(dp[m-1]);
        return dp[m-1];


    }

    public static void main(String args[]){
        int[] a = new int[]{1,1,3,4};
        maximumTotalDamage(a);
    }
}
