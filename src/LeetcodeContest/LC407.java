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


    public static void main(String[] args) {
//        int res = minChanges(14,13);
        //System.out.println(res);
        System.out.println(doesAliceWin("bbcd"));
    }
}
