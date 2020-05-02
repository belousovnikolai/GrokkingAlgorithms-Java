package chapter7.dijkstras_algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstrasAlgorithm {
    private static List<String> processed = new ArrayList<>();

    public static void dijkstrasAlgorithm( Map<String, Map<String, Integer>> graph, Map<String, Integer> costs, Map<String, String> parents) {
        // Find the lowest-cost node that you haven’t processed yet.
        String node = findLowestCodeNode(costs);

        while(node != null) { // If you’ve processed all the nodes, this while loop is done.
            Integer cost = costs.get(node);
            Map<String, Integer> neighbors = graph.get(node);

            for (String n : neighbors.keySet()) { // Go through all the neighbors of this node.
                Integer newCost = cost + neighbors.get(n);
                if(costs.get(n) > newCost) {  // If it’s cheaper to get to this neighbor by going through this node ...
                    costs.put(n, newCost); // ... update the cost for this node.
                    parents.put(n, node); // This node becomes the new parent for this neighbor.
                }
            }
            processed.add(node); // Mark node as processed
            node = findLowestCodeNode(costs); // Find the next node to process, and loop.
        }
        System.out.println(costs.get("fin")); // print the shortest path from start to finish
        processed.clear(); // clear 'processed' array after all done
    }

    private static String findLowestCodeNode(Map<String, Integer> costs) {
        Integer lowestCost = Integer.MAX_VALUE;
        String lowestCostNode = null;

        for (String node : costs.keySet()) {
            Integer cost = costs.get(node);
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }

    public static void main(String[] args) {
        // Algorithm run for graphs given in 'Exercise 7.1'

        // Graph 'A'
        Map<String, Map<String, Integer>> graphA = new HashMap<>();
        graphA.put("start", new HashMap<>());
        graphA.get("start").put("A", 5);
        graphA.get("start").put("C", 2);
        graphA.put("A", new HashMap<>());
        graphA.get("A").put("B", 4);
        graphA.get("A").put("D", 2);
        graphA.put("C", new HashMap<>());
        graphA.get("C").put("A", 8);
        graphA.get("C").put("D", 7);
        graphA.put("B", new HashMap<>());
        graphA.get("B").put("fin", 3);
        graphA.get("B").put("D", 6);
        graphA.put("D", new HashMap<>());
        graphA.get("D").put("fin", 1);
        graphA.put("fin", new HashMap<>());

        Map<String, Integer> costsA = new HashMap<>();
        costsA.put("A", 5);
        costsA.put("B", Integer.MAX_VALUE);
        costsA.put("C", 2);
        costsA.put("D", Integer.MAX_VALUE);
        costsA.put("fin", Integer.MAX_VALUE);

        Map<String, String> parentsA = new HashMap<>();
        parentsA.put("A", "start");
        parentsA.put("B", null);
        parentsA.put("C", "start");
        parentsA.put("D", null);
        parentsA.put("fin", null);

        dijkstrasAlgorithm(graphA, costsA, parentsA);

        // Graph 'B'
        Map<String, Map<String, Integer>> graphB = new HashMap<>();
        graphB.put("start", new HashMap<>());
        graphB.get("start").put("A", 10);
        graphB.put("A", new HashMap<>());
        graphB.get("A").put("B", 20);
        graphB.put("B", new HashMap<>());
        graphB.get("B").put("C", 1);
        graphB.get("B").put("fin", 30);
        graphB.put("C", new HashMap<>());
        graphB.get("C").put("A", 1);
        graphB.put("fin", new HashMap<>());

        Map<String, Integer> costsB = new HashMap<>();
        costsB.put("A", 10);
        costsB.put("B", Integer.MAX_VALUE);
        costsB.put("C", Integer.MAX_VALUE);
        costsB.put("fin", Integer.MAX_VALUE);

        Map<String, String> parentsB = new HashMap<>();
        parentsB.put("A", "start");
        parentsB.put("B", null);
        parentsB.put("C", null);
        parentsB.put("fin", null);

        dijkstrasAlgorithm(graphB, costsB, parentsB);

        // Graph 'C'
        // Is a not valid input for Dijkstras Algorithm because of the negative weight path
    }
}
