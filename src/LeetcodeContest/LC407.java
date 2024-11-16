package LeetcodeContest;

public class LC407 {

    public  static int minChanges(int n, int k) {

        String s1 = Integer.toBinaryString(n);
        String s2 = Integer.toBinaryString(k);

//        System.out.println(s1);
//        System.out.println(s2);

        int l1 = s1.length();
        int l2 = s2.length();

        if(l1>l2) {
                int addZero = l1 - l2;
                while (addZero > 0) {
                    s2 = "0" + s2;
                    addZero--;
                }

        }else if(l2>l1){
                int addZero = l2-l1;
                while(addZero>0){
                    s1 = "0" + s1;
                    addZero--;
                }

        }
//        System.out.println(s1);
//        System.out.println(s2);

        int m = s1.length();
        int count = 0;
        for(int i=0; i<m; i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(s1.charAt(i)=='1')
                    count ++;
                else if(s1.charAt(i)=='0')
                    return -1;

            }
        }
        return count;

    }

    public static boolean doesAliceWin(String s) {

        int n = s.length();

        for(int i=0; i<n; i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i'|| s.charAt(i)=='o'|| s.charAt(i)=='u')
                return true;
        }
        return false;

    }

    public static int maxOperations(String s) {

        int impact = 0;
        boolean flag = false;
        boolean prevFlag = false;
        int n = s.length();
        int count = 0;
        int res = 0;
        int startIndex = 0;
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i)=='0') {
                startIndex = i;
                break;
            }
        }

        for(int i=startIndex; i>=0; i--){

            if(s.charAt(i) == '0'){
                prevFlag = flag;
                flag = true;
                if(prevFlag != flag) {
                    res = res + (count*impact);
                    count = 0;
                    impact += 1;
                }
            }else if(s.charAt(i) == '1'){
                prevFlag = flag;
                flag = false;
                count++;
            }
        }

        if(count!=0)
            res += (count*impact);
      //  System.out.println(res);
        return res;
    }

    public static long minimumOperations(int[] nums, int[] target) {

        int n = nums.length;
        int[] diff = new int[n];

        for(int i=0; i<n; i++){
            diff[i] = target[i]-nums[i];
        }

        long res = 0;
        int maxPos = 0;
        int maxNeg = 0;
        boolean flag = false;
        boolean posPrev = false;


        for(int i=0; i<n; i++){

            if(diff[i]==0){
                flag = true;
            }
            else if(diff[i]>0){
                if(flag == true){
                    res += diff[i];
                    flag = false;
                    maxPos = diff[i];
                }else {
                    res += maxPos > diff[i] ? 0 : (diff[i] - maxPos);
                    maxPos = maxPos < diff[i] ? diff[i] : maxPos;
                    if(diff[i]<maxPos)
                        maxPos = diff[i];
                }
                posPrev = true;
            }
            else if(diff[i]<0){
                if(posPrev == true || (i>=1 && diff[i-1]==0) ){
                    res += Math.abs(diff[i]);
                    posPrev = false;
                    flag = true;
                    maxNeg =  maxNeg < diff[i] ? diff[i] : maxNeg;
                    if(diff[i]<maxNeg)
                        maxNeg = diff[i];
                }else {
                    res += maxNeg < diff[i] ? 0 : (Math.abs(diff[i]) - Math.abs(maxNeg));
                    maxNeg = maxNeg > diff[i] ? diff[i] : maxNeg;
                    flag = true;
                    if(diff[i]>maxNeg)
                        maxNeg = diff[i];
                }
            }
        }
          System.out.println(res);
        return  res;
    }


    public static void main(String[] args) {
//        int res = minChanges(14,13);
        //System.out.println(res);
//        System.out.println(doesAliceWin("bbcd"));
    //    maxOperations("1001101");

        int[] nums = new int[]{1,1,5,9,9,6};
        int[] target = new int[]{1,9,7,5,8,3};
        minimumOperations(nums,target);

    }
}
