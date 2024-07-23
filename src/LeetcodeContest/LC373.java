package LeetcodeContest;

public class LC373 {


    public static int beautifulSubstrings(String s, int k) {

        int n = s.length();
        int count = 0;

        for(int i=0; i<n; i++){
            int v = 0;
            int c = 0;
            for(int j=i; j<n; j++){
                if(s.charAt(j)=='a' || s.charAt(j)=='e' || s.charAt(j)=='i' || s.charAt(j)=='o' || s.charAt(j)=='u' )
                    v++;
                else
                    c++;

            }
            if(v==c){
                if((v*c)%k == 0){
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean areSimilar(int[][] mat, int k) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = new int[n][m];

        while(k>0){

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(i%2 == 0){
                        int ind = (j+2)%(m);
                        ans[i][ind] = mat[i][j];
                    }else{
                        int ind = n-(i%(m));
                        ans[i][ind] = mat[i][j];
                    }
                }
            }
            k--;
        }
        int flag = 0;
        for(int i=0; i<n; i++){
            for(int j = 0; j < m ; j++){
                if(ans[i][j] == mat[i][j])
                    continue;
                else{
                    flag = 1;
                    break;
                }
            }
        }
        return flag==1? false : true;

    }


    public static void main(String[] args) {

        /*[[1,2,3],[4,5,6],[7,8,9]], k = 4*/
        /*[[1,2,1,2],[5,5,5,5],[6,3,6,3]], k = 2*/
      //  int[][] mat = new int[][]{{1,2,1,2},{5,5,5,5},{6,3,6,3}};
        //System.out.println(areSimilar(mat,2));
        beautifulSubstrings("baeyh", 2);
    }
}
