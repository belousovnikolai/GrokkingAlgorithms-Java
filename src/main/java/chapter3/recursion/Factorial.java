package chapter3.recursion;

public class Factorial {
    public static int fact(int num) {
        if (num == 1) {
            return 1;
        }
        return num * fact(num - 1);
    }
}
