package Arrays;

public class main {

    public static int numSubarraysWithSum(int[] a, int goal) {

        int n = a.length;
        int sum = a[0];
        int i=0, j=0;
        int count  = 0;
        while(i<n && j<n){

            if(sum<goal){
                if(j==n-1){
                    sum -= a[i];
                    i++;
                }else {
                    j++;
                    sum += a[j];
                }
            }
            else if(sum==goal){

                if(j==n-1){
                    sum -= a[i];
                    i++;
                }else{
                    j++;
                    sum += a[j];
                }
                count++;
            }
            else{
                sum -= a[i];
                i++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String args[]){
        int[] a = new int[]{1,0,1,0,1};

        numSubarraysWithSum(a,2);
    }
}
