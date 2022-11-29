package algorithm.practice;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,3,5,9,19};
        int foundIdx = binarySearch(arr, 0, arr.length - 1, 5);
        System.out.println("foundIdx = " + foundIdx);
    }

    private static int binarySearch(int[] arr, int startIdx, int endIdx, int number) {
        if (startIdx > endIdx) {
            return -1;
        }

        int mid = (startIdx + endIdx) / 2;

        if (arr[mid] == number) {
            return mid;
        }
        else if (arr[mid] < number) {
            return binarySearch(arr, mid+1, endIdx, number);
        } else {
            return binarySearch(arr, startIdx, mid - 1, number);
        }
    }

}
