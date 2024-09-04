package neetcode150.advancedGraphs;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectAllPoints_1584 {

    private static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        /**
         * Initialize the Union Set
         *
         * @param n number of vertices
         */
        private UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        /**
         * Find the root of the set
         *
         * @param x vertex
         * @return root of the set
         */
        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        /**
         * Union the two sets
         *
         * @param x vertex
         * @param y vertex
         */
        private boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return false;

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                rank[rootY]++;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }

            return true;
        }
    }

    /**
     * Manhattan Distance between two points
     *
     * @param p1 point 1
     * @param p2 point 2
     * @return manhattan distance
     */
    private static int manhattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

   //---------------------------------------------kruskal's Algorithm---------------------------------------------//

    /**
     * Kruskal's Algorithm
     *
     * @param points points
     * @return minimum cost to connect all points
     */
    private static int kruskal(int[][] points) {
        // Number of vertices
        int vertex = points.length;

        /* 1. Create a graph (adjacency matrix)  with all the edges and their weights */
        int[][] graph = new int[vertex][vertex];

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) graph[i][j] = manhattanDistance(points[i], points[j]);
            }
        }

        /* 2. Create a priority queue to store the edges in increasing order of their weights */
        Queue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> graph[a[0]][a[1]] - graph[b[0]][b[1]]);
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (i != j) priorityQueue.add(new int[]{i, j});
            }
        }

        /* 3. Create a Union Find data structure to detect cycle */
        UnionFind uf = new UnionFind(vertex);
        int minCost = 0;

        /* 4. Spanning tree always will have total vertex - 1 edges */
        int minimumSpanningTree = vertex - 1;

        /* 5. Traverse through the priority queue and add the cost of edge if it doesn't form a cycle */
        while (minimumSpanningTree != 0) {
            int[] edge = priorityQueue.poll();
            assert edge != null;
            if (uf.union(edge[0], edge[1])) {
                minCost = minCost + graph[edge[0]][edge[1]];
                minimumSpanningTree--;
            }
        }

        return minCost;
    }

    //---------------------------------------------Prims Algorithm---------------------------------------------//

    private static int prims(int[][] points) {
        // Number of vertices
        int vertex = points.length;

        /* 1. Create a graph (adjacency matrix)  with all the edges and their weights */
        int[][] graph = new int[vertex][vertex];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) graph[i][j] = manhattanDistance(points[i], points[j]);
            }
        }

        /* 2. create a priority queue to store weight and destination vertex */
        Queue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        priorityQueue.add(new int[]{0, 0});
        /* 3. Create a visited array to keep track of visited vertices */
        boolean[] visited = new boolean[vertex];
        int minCost = 0;

        while (!priorityQueue.isEmpty()) {
            int[] edge = priorityQueue.poll();
            int weight = edge[0];
            int vertexIndex = edge[1];

            if (visited[vertexIndex]) continue;
            visited[vertexIndex] = true;
            minCost += weight;

            /* 4. Traverse through the graph find the minimum vertex with minimum edges connects to it and add to priority queue*/
            for (int i = 0; i < vertex; i++) {
                if (!visited[i]) {
                    priorityQueue.add(new int[]{graph[vertexIndex][i], i});
                }
            }
        }

        return minCost;
    }


    public static int minCostConnectPoints(int[][] points) {
        return prims(points);
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(kruskal(points));
        System.out.println(prims(points));
    }

}
