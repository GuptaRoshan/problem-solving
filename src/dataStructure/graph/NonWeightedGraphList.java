package dataStructure.graph;

import java.util.*;

//--------------------------------------------using list------------------------------------//
@SuppressWarnings("all")
class NonWeightedGraphList {

    final int vertices;
    final List<List<Integer>> adjacencyList;

    // Constructor
    public NonWeightedGraphList(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<List<Integer>>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Representation of the undirected graph:
    //
    //     0 --- 1
    //     |     |
    //     |     |
    //     3 --- 2
    //
    // Adjacency List Representation:
    //     0: [1, 3]
    //     1: [0, 2]
    //     2: [1, 3]
    //     3: [0, 2]
    //
    // Add an edge from source to destination the graph
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        // For undirected graph
        adjacencyList.get(destination).add(source);
    }


    // DFS traversal
    public List<Integer> dfs(int start) {
        boolean[] visited = new boolean[vertices]; // Visited set to mark the visited vertices
        List<Integer> result = new ArrayList<>(); // Result list to store the traversal order
        Stack<Integer> stack = new Stack<>(); // Stack to perform the DFS traversal

        stack.push(start);
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
             // if its not visited
            if (!visited[vertex]) {
                visited[vertex] = true;
                result.add(vertex);

                // Add all the neighbors of the vertex to the stack
                for (int neighbor : adjacencyList.get(vertex)) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return result;
    }

    // Recursive DFS traversal
    public List<Integer> dfsRecursive(int start) {
        boolean[] visited = new boolean[vertices]; // Visited set to mark the visited vertices
        List<Integer> result = new ArrayList<>(); // Result list to store the traversal order
        dfsHelper(start, visited, result);
        return result;
    }

    // Helper method for recursive DFS
    private void dfsHelper(int vertex, boolean[] visited, List<Integer> result) {
        visited[vertex] = true; // Mark the current vertex as visited
        result.add(vertex); // Add the current vertex to the result list

        // Visit all the unvisited neighbors of the current vertex
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited, result);
            }
        }
    }


    // BFS traversal
    public List<Integer> bfs(int start) {
        boolean[] visited = new boolean[vertices]; // Visited set to mark the visited vertices
        List<Integer> result = new ArrayList<>(); // Result list to store the traversal order
        Queue<Integer> queue = new LinkedList<>(); // Queue to perform the BFS traversal

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            result.add(vertex);

            // Visit and add all the neighbors of the vertex to the queue
            for (int neighbor : adjacencyList.get(vertex)) {
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
    }
}


//--------------------------------------------using map------------------------------------//
class UnweightedGraphMap {

    private final Map<String, Set<String>> adjacencyMap;

    // Constructor
    public UnweightedGraphMap() {
        this.adjacencyMap = new HashMap<>();
    }

    // Add an edge from source to destination in the graph
    public void addEdge(String source, String destination) {
        // Vertices initialization
        adjacencyMap.putIfAbsent(source, new HashSet<>());
        adjacencyMap.putIfAbsent(destination, new HashSet<>());

        // Add the edge
        adjacencyMap.get(source).add(destination);
        // For undirected graph, add the reverse edge
        adjacencyMap.get(destination).add(source);
    }

    // DFS traversal
    public List<String> dfs(String start) {
        Set<String> visited = new HashSet<>(); // Visited a set to mark the visited vertices
        List<String> result = new ArrayList<>(); // Result list to store the traversal order
        Stack<String> stack = new Stack<>(); // Stack to perform the DFS traversal

        stack.push(start);

        while (!stack.isEmpty()) {
            String vertex = stack.pop();

            if (!visited.contains(vertex)) {
                visited.add(vertex);
                result.add(vertex);

                // Add all the neighbors of the vertex to the stack
                for (String neighbor : adjacencyMap.get(vertex)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return result;
    }

    // Recursive DFS traversal
    public List<String> dfsRecursive(String start) {
        Set<String> visited = new HashSet<>(); // Set to track visited vertices
        List<String> result = new ArrayList<>(); // List to store traversal order
        dfsHelper(start, visited, result);
        return result;
    }

    // Helper method for recursive DFS
    private void dfsHelper(String vertex, Set<String> visited, List<String> result) {
        visited.add(vertex); // Mark the current vertex as visited
        result.add(vertex); // Add the current vertex to the result list

        // Visit all the unvisited neighbors of the current vertex
        for (String neighbor : adjacencyMap.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited, result);
            }
        }
    }

    // BFS traversal
    public List<String> bfs(String start) {
        Set<String> visited = new HashSet<>(); // Visited a set to mark the visited vertices
        List<String> result = new ArrayList<>(); // Result list to store the traversal order
        Queue<String> queue = new LinkedList<>(); // Queue to perform the BFS traversal

        visited.add(start);
        queue.offer(start);

        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            result.add(vertex);

            // Visit and add all the neighbors of the vertex to the queue
            for (String neighbor : adjacencyMap.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        UnweightedGraphMap graph = new UnweightedGraphMap();
        graph.addEdge("0", "1");
        graph.addEdge("0", "3");
        graph.addEdge("1", "2");
        graph.addEdge("2", "3");
    }
}


