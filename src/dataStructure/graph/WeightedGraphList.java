package dataStructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//--------------------------------------------using List------------------------------------//

@SuppressWarnings("all")
class WeightedGraphList {

    private final int vertices;
    private final List<List<Edge>> adjacencyList;

    // Constructor
    public WeightedGraphList(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Add an edge from source to destination the graph
    public void addEdge(int source, int destination, int weight) {
        adjacencyList.get(source).add(new Edge(destination, weight));
        // For undirected graph
        adjacencyList.get(destination).add(new Edge(source, weight));
    }

    public static void main(String[] args) {
        WeightedGraphList graph = new WeightedGraphList(5);

        graph.addEdge(0, 1, 30);
        graph.addEdge(0, 3, 40);
        graph.addEdge(1, 2, 50);
        graph.addEdge(2, 3, 60);
    }
}

//--------------------------------------------using map------------------------------------//

@SuppressWarnings("all")
class WeightedGraphMap {
    private final Map<String, Map<String, Integer>> adjacencyMap;

    // Constructor
    public WeightedGraphMap() {
        this.adjacencyMap = new HashMap<>();
    }

    // Add an edge from source to destination in the graph
    public void addEdge(String source, String destination, int weight) {
        // Vertices initialization
        adjacencyMap.putIfAbsent(source, new HashMap<>());
        adjacencyMap.putIfAbsent(destination, new HashMap<>());

        // Add the edge
        adjacencyMap.get(source).put(destination, weight);
        // For undirected graph, add the reverse edge
        adjacencyMap.get(destination).put(source, weight);
    }


    public static void main(String[] args) {
        WeightedGraphMap graph = new WeightedGraphMap();

        graph.addEdge("0", "1", 5);
        graph.addEdge("0", "3", 6);
        graph.addEdge("1", "2", 10);
        graph.addEdge("2", "3", 4);
    }
}
