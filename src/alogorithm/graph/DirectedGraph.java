package alogorithm.graph;

import alogorithm.graph.edge.UndirectedEdge;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph {

    public final int totalVertices;
    public final List<List<UndirectedEdge>> adjacencyList;

    public DirectedGraph(int totalVertices) {
        this.totalVertices = totalVertices;
        this.adjacencyList = new ArrayList<>();

        for (int i = 0; i < totalVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjacencyList.get(src).add(new UndirectedEdge(dest, weight));
    }

}
