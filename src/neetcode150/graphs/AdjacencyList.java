package neetcode150.graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {

    public int vertices;
    public List<List<Integer>> neighbor;


    public AdjacencyList(int vertices) {
        this.vertices = vertices;
        this.neighbor = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            neighbor.add(new ArrayList<>());
        }
    }


    // Add an edge from source to destination in the graph
    public void addEdge(int source, int destination) {
        neighbor.get(source).add(destination);
        neighbor.get(destination).add(source); // For undirected graph
    }

}
