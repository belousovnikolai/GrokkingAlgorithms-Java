package chapter4.quicksort;

public class QuickSort {

    public static void quickSort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    private static void quickSort(int[] A, int from, int to) {
        if (from < to) {
            int divideIndex = partition(A, from, to);
            quickSort(A, from, divideIndex - 1);
            quickSort(A, divideIndex, to);
        }
    }

    private static int partition(int[] A, int from, int to) {
        int leftIndex = from;
        int rightIndex = to;
        int pivot = A[from + (to - from) / 2];

        while (leftIndex <= rightIndex) {
            while (A[leftIndex] < pivot) {
                leftIndex++;
            }
            while (A[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                swap(A, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
}
