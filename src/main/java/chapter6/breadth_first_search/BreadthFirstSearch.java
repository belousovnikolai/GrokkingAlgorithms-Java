package chapter6.breadth_first_search;

import java.util.*;

public class BreadthFirstSearch {
    public static boolean breadthFirstSearch(Map<String, List<String>> friends, String name) {
        Deque<String> queue = new ArrayDeque<>(friends.get(name));
        List<String> searched = new ArrayList<>();

        while (!queue.isEmpty()) {
            String person = queue.poll();
            if (!searched.contains(person)) {
                System.out.println("Checking: " + person);
                if (isSeller(person)) {
                    System.out.println(person + " is a mango seller");
                    return true;
                }
                queue.addAll(friends.get(person));
                searched.add(person);
            }
        }
        return false;
    }

    private static boolean isSeller(String name) {
        return name.endsWith("m");
    }
}
