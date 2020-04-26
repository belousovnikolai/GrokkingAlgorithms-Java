package chapter1.binary_search;

public class BinarySearch {

    // iterative approach
    public static int binarySearch(int[] arr, int val) {
        int from = 0;
        int to = arr.length - 1;

        while (from <= to) {
            int mid = (from + to) / 2;
            int guess = arr[mid];

            if (guess > val) {
                to = mid - 1;
            } else if (guess == val) {
                return mid;
            } else {
                from = mid + 1;
            }
        }

        return -1;
    }
}
