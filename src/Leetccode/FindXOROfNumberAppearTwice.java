package Leetccode;

import java.util.*;
public class FindXOROfNumberAppearTwice {

    public int duplicateNumbersXOR(int[] a) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        for(int i=0; i<a.length; i++){

            if(hm.containsKey(a[i]))
                hm.put(a[i],hm.get(a[i])+1);
            else
                hm.put(a[i],1);
        }
        for (Map.Entry<Integer, Integer> set :
                hm.entrySet()) {

            if(set.getValue()==2)
                ans = ans^set.getKey();

        }
        return ans;
    }
}
