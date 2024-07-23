package DP;

import java.util.*;
public class PascalTriangle {


    public static int pascal(int n){

        int[][] dp = new int[n+2][n+2];

        Arrays.stream(dp).forEach(a -> Arrays.fill(a, 0));

        for(int i=0; i<=n; i++)
            dp[i][0] = 1;

        for(int i=0; i<=n; i++)
            dp[i][i] = 1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++)
                dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
        }

        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++)
                System.out.print(dp[i][j]+ " ");

            System.out.println();
        }
        return 0;
    }

    public static void main(String args[]){
        pascal(5);
    }
}
