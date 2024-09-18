package dataStructure.graph;

import java.util.*;

//--------------------------------------------using list------------------------------------//
@SuppressWarnings("all")
class NonWeightedGraphList {

    public final int vertices;
    public final List<List<Integer>> adjacencyList;

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

    public static void main(String[] args) {
        UnweightedGraphMap graph = new UnweightedGraphMap();
        graph.addEdge("0", "1");
        graph.addEdge("0", "3");
        graph.addEdge("1", "2");
        graph.addEdge("2", "3");
    }
}


