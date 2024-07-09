package GoldmanSachs;

public class quickSort {

    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high){

        int pivot = arr[low];
        int i = low;
        int j = high;

        while(i<j){

            while(arr[i]<=pivot && i<=high-1){
                i++;
            }
            while(arr[j]>=pivot && j>=low+1){
                j--;
            }
            if(i<j)
              swap(arr, i, j);

        }

        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void quickSortUtil(int[] arr, int low, int high){
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSortUtil(arr,low, partitionIndex-1);
            quickSortUtil(arr, partitionIndex+1, high);
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{4,6,2,5,7,9,1,3};
        quickSortUtil(arr, 0, arr.length-1);
        for(int i : arr)
            System.out.println(i + " ");
    }
}
