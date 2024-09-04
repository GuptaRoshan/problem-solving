package neetcode150.graphs;

import java.util.Arrays;

@SuppressWarnings("all")
public class RedundantConnection_684 {

    /**
     * Union-Find (Disjoint Set Union) is a data structure used to manage a partition of a set into disjoint (non-overlapping) subsets.
     * It supports two main operations: find and union. The structure uses path compression and union by rank to ensure efficient performance.
     */
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
         * Find operation:
         * This method finds the representative or root of the set containing the element 'x'.
         * It uses path compression to flatten the structure of the tree, making future operations faster.
         * <p>
         * Example:
         * Consider the parent array [0, 1, 1, 1]:
         * - Calling find(2):
         * - Path: 2 -> 1 (root of 2 is 1).
         * - Parent array will be updated to [0, 1, 1, 1] due to path compression (if needed).
         * - Root of 2 is 1.
         *
         * @param x The element whose root is to be found.
         * @return The root of the set containing 'x'.
         */
        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        /**
         * Union operation:
         * This method merges the sets containing elements 'x' and 'y'.
         * It uses union by rank to attach the smaller tree under the root of the larger tree, keeping the tree shallow and efficient.
         * <p>
         * Example:
         * Given the initial parent array [0, 1, 2, 3] and rank array [0, 0, 0, 0]:
         * - Calling union(1, 2):
         * - Find roots: root of 1 is 1, root of 2 is 2.
         * - Ranks are equal, attach 2 under 1.
         * - Updated parent array: [0, 1, 1, 3], rank array: [0, 1, 0, 0].
         * - Calling union(2, 3):
         * - Find roots: root of 2 is 1, root of 3 is 3.
         * - Attach 3 under 1 (root of 1 has higher rank).
         * - Updated parent array: [0, 1, 1, 1], rank array: [0, 2, 0, 0].
         *
         * @param x The first element.
         * @param y The second element.
         * @return true if the union was successful (i.e., the two elements were in different sets), false otherwise (i.e., they were already in the same set).
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
     * Find the redundant connection
     *
     * @param edges edges of the graph
     * @return redundant connection
     */
    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] result = findRedundantConnection(edges);
        System.out.println(Arrays.toString(result));
    }


}
