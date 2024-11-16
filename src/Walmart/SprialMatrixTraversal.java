package Walmart;

public class SprialMatrixTraversal {

    public static void spiralPrint(int[][] a){

        int n = a.length;
        int m = a[0].length;

        int left = 0, top = 0, right = m-1, bottom = n-1;

        while(left <= right && top <= bottom){

            for(int i=left; i<=right; i++)
                System.out.println(a[top][i]);

            top++;

            for(int i=top; i<=bottom; i++)
                System.out.println(a[i][right]);

            right--;

            if(top<=bottom){

                for(int i=right; i>=left; i--)
                    System.out.println(a[bottom][i]);

                bottom--;
            }

            if(left <= right){

                for(int i=bottom; i>=top; i--)
                    System.out.println(a[i][left]);

                left++;
            }
        }


    }

    public static void main(String[] args) {

        int[][] a = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        spiralPrint(a);
    }
}
