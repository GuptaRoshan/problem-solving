package dataStructure.graph;

import java.util.*;

public class Traversal {

    NonWeightedGraphList graph;

    Traversal(NonWeightedGraphList graph) {
        this.graph = graph;
    }

    /*-------------------------- DFS traversal using stack-------------------------- */
    public List<Integer> DFSUsingStack(int start) {
        boolean[] visited = new boolean[graph.vertices];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited[vertex]) {
                visited[vertex] = true;
                result.add(vertex);

                for (int neighbor : graph.adjacencyList.get(vertex)) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return result;
    }

    /*-------------------------- Recursive DFS traversal -------------------------- */
    public List<Integer> DFSUsingRecursion(int start) {
        boolean[] visited = new boolean[graph.vertices];
        List<Integer> result = new ArrayList<>();
        dfsHelper(start, visited, result);
        return result;
    }

    // Helper method for recursive DFS
    private void dfsHelper(int vertex, boolean[] visited, List<Integer> result) {
        visited[vertex] = true;
        result.add(vertex);
        // Visit all the unvisited neighbors of the current vertex
        for (int neighbor : graph.adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited, result);
            }
        }
    }


    /*-------------------------- BFS traversal -------------------------- */
    public List<Integer> BFS(int start) {
        boolean[] visited = new boolean[graph.vertices];
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            result.add(vertex);

            // Visit and add all the neighbors of the vertex to the queue
            for (int neighbor : graph.adjacencyList.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        NonWeightedGraphList graph = new NonWeightedGraphList(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        new Traversal(graph);
    }


}
