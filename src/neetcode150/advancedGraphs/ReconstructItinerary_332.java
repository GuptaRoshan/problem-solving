package neetcode150.advancedGraphs;

import java.util.*;

public class ReconstructItinerary_332 {

    /**
     * This eulerian path problem can be solved using Hierholzer's algorithm. The idea is to keep going forward until you get stuck.
     * Once you get stuck, you add the current airport to the route and backtrack to the previous airport. This way you can keep track of the route.
     *
     * @param tickets List of Strings
     * @return List of Strings
     */
    public static List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> route = new LinkedList<>();
        Map<String, PriorityQueue<String>> airports = new HashMap<>();

        for (List<String> ticket : tickets) {
            airports.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        DFS(airports, "JFK", route);
        return route;
    }

    /**
     * Working of this function :
     * <p>
     * 1. Initially, we start at the airport JFK.
     * airports = {'JFK': ['D', 'A'], 'A': ['C'], 'B': ['C'], 'C': ['JFK', 'D'], 'D': ['B', 'A']}
     * route = []
     * stack = ['JFK']
     * <p>
     * 2. We keep going forward until we get stuck.
     * airports = {'JFK': ['D'], 'A': [], 'B': ['C'], 'C': ['JFK', 'D'], 'D': ['B']}
     * route = []
     * stack = ['JFK', 'A', 'C', 'D', 'A']
     * <p>
     * 3. Once we get stuck, we add the current airport to the route and backtrack to the previous airport.
     * airports = {'JFK': ['D'], 'A': [], 'B': ['C'], 'C': ['JFK'], 'D': ['B']}
     * route = ['A']
     * stack = ['JFK', 'A', 'C', 'D']
     * <p>
     * 4. We keep going forward until we get stuck.
     * airports = {'JFK': [], 'A': [], 'B': [], 'C': [], 'D': []}
     * route = ['A']
     * stack = ['JFK', 'A', 'C', 'D', 'B', 'C', 'JFK', 'D']
     * <p>
     * 5. Once we get stuck, we add the current airport to the route and backtrack to the previous airport.
     * airports = {'JFK': [], 'A': [], 'B': [], 'C': [], 'D': []}
     * route = ['JFK', 'A', 'C', 'D', 'B', 'C', 'JFK', 'D', 'A']
     * stack = []
     *
     * @param airports  Map of Strings and PriorityQueues
     * @param departure String
     * @param route     LinkedList of Strings
     */
    private static void DFS(Map<String, PriorityQueue<String>> airports, String departure, LinkedList<String> route) {
        while (airports.containsKey(departure) && !airports.get(departure).isEmpty()) {
            DFS(airports, airports.get(departure).poll(), route);
        }
        route.addFirst(departure);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        // Initialize the graph directly with edges
        tickets.add(new ArrayList<>(Arrays.asList("JFK", "D")));
        tickets.add(new ArrayList<>(Arrays.asList("JFK", "A")));
        tickets.add(new ArrayList<>(Arrays.asList("A", "C")));
        tickets.add(new ArrayList<>(Arrays.asList("B", "C")));
        tickets.add(new ArrayList<>(Arrays.asList("C", "JFK")));
        tickets.add(new ArrayList<>(Arrays.asList("C", "D")));
        tickets.add(new ArrayList<>(Arrays.asList("D", "B")));
        tickets.add(new ArrayList<>(Arrays.asList("D", "A")));

        System.out.println(findItinerary(tickets));
    }

}
