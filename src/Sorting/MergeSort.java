package Sorting;


import java.util.*;

public class MergeSort {

    //a1 - [1,3,4,5] a2 - [2,5,6,8]
    public static int[] mergeTwoSortedArray(int[] a1, int[] a2){

        int n = a1.length;
        int m = a2.length;
        int[] ans = new int[n+m];
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        while(p1<n && p2<m){

            if(a1[p1] <= a2[p2]){
                ans[p3]=a1[p1];
                p3++;
                p1++;
            }
            else if(a1[p1] > a2[p2]){
                ans[p3]=a2[p2];
                p3++;
                p2++;
            }
        }
        while(p1!=n){
             ans[p3] = a1[p1];
             p1++;
             p3++;
        }
        while(p2!=m){
            ans[p3] = a2[p2];
            p3++;
            p2++;
        }
        return ans;
    }
    public static int[] mergeSortedArray(int[] a, int low, int mid, int high){

        int left = low;
        int right = mid+1;
        List<Integer> ls = new ArrayList<>();

        while(left<=mid && right<=high){

            if(a[left]<a[right]){
                ls.add(a[left]);
                left++;
            }
            else {
                ls.add(a[right]);
                right++;
            }
        }
        while(left<=mid){
            ls.add(a[left]);
            left++;
        }
        while(right<=high){
            ls.add(a[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            a[i] = ls.get(i - low);
        }
        return a;
    }
    public static void mergeSort(int[] a, int low, int high){

        if(low>=high)
            return ;
        int m = (low+high)/2;
        mergeSort(a,low,m);
        mergeSort(a,m+1,high);
        mergeSortedArray(a,low,m,high);

    }
    public static void main(String args[]){

        int[] a = new int[]{1,4,8,6};
        MergeSort.mergeSort(a,0,3);
        for(int i : a)
            System.out.println(i);
    }

}
