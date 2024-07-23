package Leetccode;

public class digitFreq {


        public static long sumDigitDifferences(int[] nums) {

            int n = nums[0];
            int digcount = 0;
            while(n!=0){
                digcount++;
                n=n/10;
            }
            long ans = 0;
            for(int i=0; i<digcount; i++){
                int[] freq = new int[10];
                for(int j=0; j<nums.length; j++){
                    freq[nums[j]%10]++;
                    nums[j]=nums[j]/10;
                }
                for(int k=0; k<10; k++){
                    for(int l=k+1; l<10; l++)
                        ans += (long)freq[k]*(long)freq[l];
                }
            }
            return ans;
        }

        public static void main(String args[]){

            int[] nums = new int[]{13,23,12};
            sumDigitDifferences(nums);
        }
}
