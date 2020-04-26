package chapter3.recursion;

public class Countdown {
    private static void countdown(int i) {
        System.out.println(i);

        if (i == 0) {
            System.out.println("Time!");
        } else {
            countdown(i - 1);
        }
    }
}
