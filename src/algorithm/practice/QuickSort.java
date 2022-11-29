package algorithm.practice;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {50,10,20,70,30,90,80,40,100,60};
        solve(arr);
        for (int number : arr) {
            System.out.print(number + " ");
        }
    }

    private static void solve(int[] arr) {
        quickSort(arr,0,arr.length-1);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        int index = left;

        while (i < right) {
            if (pivot >= arr[i]) {
                swap(arr, index, i);
                index += 1;
            }
            i += 1;
        }
        swap(arr, index, right);

        return index;
    }

    private static void swap(int[] arr, int index, int i) {
        int tmp = arr[index];
        arr[index] = arr[i];
        arr[i] = tmp;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int index = partition(arr, left, right);
            quickSort(arr, left, index-1);
            quickSort(arr, index+1, right);
        }
    }

}
