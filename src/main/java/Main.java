import algorithms.BinarySearch;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {214, 4, 46, 8, 55, 53, 65};
        int v = 65;

        System.out.println(BinarySearch.binarySearch(array, v));
    }
}