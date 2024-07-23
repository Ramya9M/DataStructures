public  class  Demo {

    static int findParity(int x)
    {
        int y = x ^ (x >> 1);
        y = y ^ (y >> 2);
        y = y ^ (y >> 4);
        y = y ^ (y >> 8);
        y = y ^ (y >> 16);

        if ((y & 1) > 0)
            return 1;
        return 0;
    }
    public static boolean isArraySpecial(int[] nums) {

        int flag = 0;
        for(int i=0; i<nums.length-1; i++){
            if(findParity(nums[i])!=findParity(nums[i+1]))
                continue;
            else{
                flag = 1;
                break;
            }
        }
        if(flag==0)
            return true;
        else
            return false;
    }

    public static void main(String args[]){

        int[] arr = new int[]{2,1,4};
        boolean ans = isArraySpecial(arr);
    }
}



