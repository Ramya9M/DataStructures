package BitManipulation;

public class CountBitsInDigit {

    public static int[] countBits(int n) {

        int[] res = new int[n+1];

        for(int i=0; i<=n; i++){
            int count = 0;
            for(int j=0; j<32; j++){
                if((i & (1<<j)) == 1)
                    count++;
            }
            res[i] = count;
        }

        for(int i : res)
            System.out.println(i);
        return res;
    }


    public static void main(String args[]){

        countBits(2);
    }
}
