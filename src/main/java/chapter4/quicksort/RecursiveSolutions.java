package chapter4.quicksort;

import java.util.Arrays;

public class RecursiveSolutions {

    public static int sum(int[] array) {
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }
        return array[0] + sum(Arrays.copyOfRange(array, 1, array.length));
    }

    public static int countItems(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        return 1 + countItems(Arrays.copyOf(array, array.length - 1));
    }

    public static int findMax(int[] array, int l) {
        if (l == 1) {
            return array[0];
        }
        return max(array[l-1], findMax(array, l-1));
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int binarySearchRecursive(int[] arr, int from, int to, int val) {
        if (from > to) {
            return -1;
        }

        int mid = (to + from) / 2;
        int guess = arr[mid];

        if (guess == val) {
            return mid;
        } else if (guess > val) {
            return binarySearchRecursive(arr, from, mid - 1, val);
        }
        return binarySearchRecursive(arr, mid + 1, to, val);
    }
}