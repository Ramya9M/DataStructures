package Walmart;

public class SortArray012 {


    public static void sortArray(int[] a){

        int l =0;
        int m = 0;
        int h = a.length-1;

        while(m<=h){
            if(a[m]==0){
                int temp = a[l];
                a[l] = a[m];
                a[m] = temp;
                l++;
                m++;
            }
            else if(a[m] == 1){
                m++;
            }
            else if(a[m]==2){
                int temp = a[m];
                a[m] = a[h];
                a[h] = temp;
                h--;
            }
        }

    }


    public static void main(String[] args) {

        int nums[] =new int[]{0,1,2,0,1,2};
        sortArray(nums);
        for(int i : nums)
            System.out.println(i);

    }
}
