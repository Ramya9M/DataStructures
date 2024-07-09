package GoldmanSachs;

public class mereTwoSortedArray {

    public static void mergeTwoSortedArray(int[] a, int[] b){

        int n = a.length;
        int m = b.length;

        int p1=0;
        int p2=0;
        int p3=0;
        int[] ans = new int[n+m];

        while(p1<n && p2<m){

            if(a[p1]<b[p2]){
                ans[p3] = a[p1];
                p3++;
                p1++;
            }else{
                ans[p3] = b[p2];
                p3++;
                p2++;
            }
        }
        while(p1!=n){
            ans[p3] = a[p1];
            p3++;
            p1++;
        }
        while(p2!=m){
            ans[p3] = b[p2];
            p3++;
            p2++;
        }
        for(int i =0; i<n+m; i++)
            System.out.println(ans[i] + " ");
    }
    
    public static void main(String[] args) {

        int[] a1 = new int[]{3,2,9,11};
        int[] a2 = new int[]{1,8,14,19};
        mergeTwoSortedArray(a1,a2);
    }
}
