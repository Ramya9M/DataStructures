package Graphs;

import java.util.*;
public class DFSPractice {
    private boolean dfs(boolean[][] graph , int src, int des,boolean[] vis, int n){
        if(src==des)
            return true;

        vis[src] = true;

        for(int i=0; i<n; i++){
            if(graph[src][i] == true && !vis[i]){
                if(dfs(graph, i, des, vis, n))
                    return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int src, int des) {

        boolean[][] graph = new boolean[n][n];
        for(boolean[] row : graph)
            Arrays.fill(row, false);
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph[u][v] = true;
            graph[v][u] = true;
        }
        boolean[] vis = new boolean[n];
        return dfs(graph, src, des, vis, n);

    }

    public static int maxTotalReward(int[] rewardValues) {

        int res = 0;
        Arrays.sort(rewardValues);
        int n = rewardValues.length;
        for(int i=0; i<n; i++){
            int ans = 0;
            for(int j=i; j<n; j++){
                if(ans<rewardValues[j]){
                    ans = ans+rewardValues[j];
                }
            }
            res = Math.max(ans, res);
        }
        System.out.println(res);
        return res;
    }

    public static void main(String args[]){
        int[] a = new int[]{2,15,14,18};
        maxTotalReward(a);
    }
}
