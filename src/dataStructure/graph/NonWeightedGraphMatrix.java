package dataStructure.graph;


import java.util.*;

@SuppressWarnings("all")
public class NonWeightedGraphMatrix {

    private final int vertices;
    private final boolean[][] adjacencyMatrix;

    // Constructor
    public NonWeightedGraphMatrix(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new boolean[vertices][vertices];
    }

    // Representation of the undirected graph:
    //
    //     0 --- 1
    //     |     |
    //     |     |
    //     3 --- 2
    //
    // Adjacency Matrix Representation:
    //       0 1 2 3
    //     ---------
    //   0 | 0 1 0 1
    //   1 | 1 0 1 0
    //   2 | 0 1 0 1
    //   3 | 1 0 1 0
    //
    // Add an edge from source to destination the graph
    public void addEdge(int source, int destination) {
        // add the edge
        adjacencyMatrix[source][destination] = true;
        // For undirected graph, add the reverse edge
        adjacencyMatrix[destination][source] = true;
    }


    // DFS traversal
    public List<Integer> dfs(int start) {
        boolean[] visited = new boolean[vertices];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (!visited[vertex]) {
                visited[vertex] = true;
                result.add(vertex);

                for (int i = vertices - 1; i >= 0; i--) {  // Push neighbors in reverse to maintain correct order
                    if (adjacencyMatrix[vertex][i] && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }

        return result;
    }

    // Recursive DFS traversal
    public List<Integer> dfsRecursive(int start) {
        boolean[] visited = new boolean[vertices];
        List<Integer> result = new ArrayList<>();
        dfsHelper(start, visited, result);
        return result;
    }

    // Helper method for recursive DFS
    private void dfsHelper(int vertex, boolean[] visited, List<Integer> result) {
        visited[vertex] = true;
        result.add(vertex);

        // Loop through all the neighbors of the vertex
        for (int i = 0; i < vertices; i++) {
            // If the vertex is connected to the current vertex and not visited
            if (adjacencyMatrix[vertex][i] && !visited[i]) {
                dfsHelper(i, visited, result);
            }
        }
    }

    // BFS traversal
    public List<Integer> bfs(int start) {
        boolean[] visited = new boolean[vertices];
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            result.add(vertex);

            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[vertex][i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        NonWeightedGraphMatrix graph = new NonWeightedGraphMatrix(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
    }
}
