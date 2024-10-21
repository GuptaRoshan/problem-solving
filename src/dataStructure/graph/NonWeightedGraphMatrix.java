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

    public static void main(String[] args) {
        NonWeightedGraphMatrix graph = new NonWeightedGraphMatrix(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
    }
}
