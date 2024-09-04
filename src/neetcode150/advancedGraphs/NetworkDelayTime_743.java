package neetcode150.advancedGraphs;

import java.util.Arrays;

public class NetworkDelayTime_743 {


    /**
     * Dijkstra's algorithm
     *
     * @param times 2D array of times
     * @param N number of nodes
     * @param K source node
     * @return time taken to reach all nodes
     */
    public static int dijkstra(int[][] times, int N, int K) {
        double[] cost = new double[N];
        Arrays.fill(cost, Double.POSITIVE_INFINITY);
        cost[K - 1] = 0;

        while (N-- > 0) {
            for (int[] t : times) {
                int u = t[0] - 1;
                int v = t[1] - 1;
                int w = t[2];

                if (cost[u] + w < cost[v]) {
                    cost[v] = cost[u] + w;
                }
            }
        }

        double max = Double.MIN_VALUE;
        for (double v : cost) {
            if (v == Double.POSITIVE_INFINITY) return -1;

            max = Math.max(max, v);
        }

        return (int) max;
    }

    /**
     * Bellman-Ford algorithm
     *
     * @param times 2D array of times
     * @param N number of nodes
     * @param K source node
     * @return time taken to reach all nodes
     */

    public static int bellmanFord(int[][] times, int N, int K) {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K - 1] = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int[] t : times) {
                int u = t[0] - 1;
                int v = t[1] - 1;
                int w = t[2];

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
                    dist[v] = dist[u] + w;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int v : dist) {
            if (v == Integer.MAX_VALUE) return -1;

            max = Math.max(max, v);
        }


        return max;
    }

    public static int networkDelayTime(int[][] times, int N, int K) {
        return bellmanFord(times, N, K);
    }


    public static void main(String[] args) {
        int[][] times = {
                {3, 5, 78},
                {2, 1, 1},
                {1, 3, 0},
                {4, 3, 59},
                {5, 3, 85},
                {5, 2, 22},
                {2, 4, 23},
                {1, 4, 43},
                {4, 5, 75},
                {5, 1, 15},
                {1, 5, 91},
                {4, 1, 16},
                {3, 2, 98},
                {3, 4, 22},
                {5, 4, 31},
                {1, 2, 0},
                {2, 5, 4},
                {4, 2, 51},
                {3, 1, 36},
                {2, 3, 59}};
        int n = 5;
        int k = 5;
        System.out.println(networkDelayTime(times, n, k));
    }

}
