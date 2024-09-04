package neetcode150.advancedGraphs;

import java.util.*;

public class CheapestFlightsWithKStops_787 {

    /**
     * Dijkstra's algorithm
     *
     * @param n number of cities
     * @param flights 2D array of flights
     * @param src source city
     * @param dst destination city
     * @param k number of stops
     * @return cheapest price
     */
    public static int dijkstra(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            int source = flight[0];
            int destination = flight[1];
            int price = flight[2];
            graph.computeIfAbsent(source, x -> new ArrayList<>()).add(new int[]{destination, price});
        }

        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{src, 0, k + 1});

        while (!queue.isEmpty()) {
            int[] flight = queue.poll();
            int currentFlight = flight[0];
            int price = flight[1];
            int stop = flight[2];

            if (currentFlight == dst) {
                return price;
            }

            if (visited.add(Arrays.toString(flight)) && stop > 0 && graph.containsKey(currentFlight)) {
                for (int[] nextFlight : graph.get(currentFlight)) {
                    queue.add(new int[]{nextFlight[0], price + nextFlight[1], stop - 1});
                }
            }
        }

        return -1;
    }


    /**
     * Bellman-Ford algorithm
     *
     * @param n number of cities
     * @param flights 2D array of flights
     * @param src source city
     * @param dst destination city
     * @param K number of stops
     * @return cheapest price
     */
    public static int bellmanFord(int n, int[][] flights, int src, int dst, int K) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        for (int i = 0; i <= K; i++) {
            int[] temp = Arrays.copyOf(cost, n);
            for (int[] f : flights) {
                int curr = f[0];
                int next = f[1];
                int price = f[2];
                if (cost[curr] == Integer.MAX_VALUE) continue;
                temp[next] = Math.min(temp[next], cost[curr] + price);
            }
            cost = temp;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
    
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         return dijkstra(n, flights, src, dst, k);
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

}
