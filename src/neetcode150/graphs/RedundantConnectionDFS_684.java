package neetcode150.graphs;

import java.util.*;

public class RedundantConnectionDFS_684 {

    // DFS to check for cycle
    private static boolean detectCycle(int currentNode, int parent, boolean[] visited, List<List<Integer>> adjacencyList) {
        visited[currentNode] = true;
        for (int neighbor : adjacencyList.get(currentNode)) {
            if (!visited[neighbor]) {
                if (detectCycle(neighbor, currentNode, visited, adjacencyList)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adjacencyList = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        int[] result = new int[2];

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);

            boolean[] visited = new boolean[n + 1];
            if (detectCycle(u, -1, visited, adjacencyList)) {
                result = edge;
                adjacencyList.get(u).removeLast();
                adjacencyList.get(v).removeLast();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] result = findRedundantConnection(edges);
        System.out.println(Arrays.toString(result));
    }

}
