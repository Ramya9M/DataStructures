package Walmart;

public class RowColumnSortedMatrix {

    public static void rowColSearch(int[][] a, int x){

        int n = a.length;
        int i=0;
        int j = n-1;

        while(i<n && j>=0){

            if(a[i][j] == x) {
                System.out.println("element found");
                break;
            }
            if(a[i][j] > x)
                j--;
            else
                i++;
        }
        if(i==n || j==0)
         System.out.println("not found");
    }


    public static void main(String[] args) {

        int[][] a = new int[][]{
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };

        rowColSearch(a, 100);

    }
}
