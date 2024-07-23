package DP;


import java.util.*;
public class DymProg {

    public static int findWays(int[][] a, int n, int m) {

        int[][] dp = new int[n][m];
        dp[0][0] = 0;

        for (int j = 1; j < m; j++) {
            if (a[0][j] == 1)
                dp[0][j] = 0;
            else if (a[0][0] == 0 && a[0][j] == 0)
                dp[0][j] = 1;
        }
        for (int j = 1; j < n; j++) {
            if (a[j][0] == 1)
                dp[j][0] = 0;
            else if (a[0][0] == 0 && a[j][0] == 0)
                dp[j][0] = 1;
        }

        for (int i = 2; i < n; i++) {
            for (int j = 2; j < m; j++) {
                if (a[i][j] == 1)
                    dp[i][j] = 0;
                else if (dp[0][j] == 1 && dp[i][0] == 1)
                    dp[i][j] = dp[0][j] + dp[i][0];

            }
        }

        return 0;
    }

    public static int numTrees(int n) {

        if (n == 1)
            return 1;

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        System.out.println(dp[n]);
        return dp[n];
    }

    public static void main(String args[]) throws Exception {

//        int n = 0;
//        int m = 0;
//        Scanner s = new Scanner(System.in);
//        System.out.println("enter the number n: ");
//        n = s.nextInt();
//        System.out.println("enter the number m: ");
//        m = s.nextInt();
//        System.out.println("enter the number matrix: ");
//        int[][] input = new int[n][m];
//
//        for(int i=0; i<n; i++){
//            for(int j=0; j<m; j++)
//                input[i][j] = s.nextInt();
//        }
        numTrees(3);

    }

    // Returns an array containing the maximum of all subarrays of size k
    public static int[] slidingWindowMax(int[] arr, int k) {
        // Initialize a deque that will store the indices of the array elements
        Deque<Integer> dq = new LinkedList<>();

        // Initialize an array to store the maximum of each subarray
        int[] maxes = new int[arr.length - k + 1];

        // Process the first k elements of the array separately
        for (int i = 0; i < k; i++) {
            // Remove any element that is smaller than the current element
            // from the back of the deque
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }

            // Add the current element to the back of the deque
            dq.addLast(i);
        }

        // Process the remaining elements of the array
        for (int i = k; i < arr.length; i++) {
            // The first element in the deque is the maximum of the previous
            // subarray, so store it in the maxes array
            maxes[i - k] = arr[dq.peekFirst()];

            // Remove any element that is smaller than the current element
            // from the back of the deque
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }

            // Remove any element that is outside the current window
            // from the front of the deque
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            // Add the current element to the back of the deque
            dq.addLast(i);
        }

        // Store the maximum of the last subarray
        maxes[arr.length - k] = arr[dq.peekFirst()];

        return maxes;
    }

}
