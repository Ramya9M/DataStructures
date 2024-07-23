package LeetcodeContest;

public class LC403 {

    public static int minimumArea(int[][] grid) {

        int rs = Integer.MAX_VALUE;
        int re = Integer.MIN_VALUE;
        int cs = Integer.MAX_VALUE;
        int ce = Integer.MIN_VALUE;

        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(grid[i][j]==1){

                    rs = Math.min(rs, i);
                    re = Math.max(re, i);
                    cs = Math.min(cs, j);
                    ce = Math.max(ce, j);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{{0,1,0},{1,0,1}};
        minimumArea(grid);
    }
}
