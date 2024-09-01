package alogorithm.graph;

import alogorithm.graph.edge.UndirectedEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimMST {

    /*
     * Prim's algorithm starts with an arbitrary vertex and grows the Minimum Spanning Tree (MST)
     * by adding the cheapest edge that connects a vertex in the MST to a vertex outside the MST.
     *
     * Analogy:
     * Imagine you're planning a subway system for a city. You start at one station and keep
     * expanding by building the shortest possible connection to the nearest unconnected station
     * until all stations are connected.
     */
    public static List<UndirectedEdge> primMST(UndirectedGraph graph) {
        int V = graph.totalVertices;

        List<UndirectedEdge> minSpanningTree = new ArrayList<>();

        boolean[] inMST = new boolean[V];
        PriorityQueue<UndirectedEdge> pq = new PriorityQueue<>((edge1, edge2) -> edge1.weight - edge2.weight);

        // Start with vertex 0
        inMST[0] = true;
        pq.addAll(graph.adjacencyList.getFirst());

        while (!pq.isEmpty()) {
            UndirectedEdge edge = pq.poll();

            if (inMST[edge.dest]) continue;

            inMST[edge.dest] = true;
            minSpanningTree.add(edge);

            for (UndirectedEdge nextEdge : graph.adjacencyList.get(edge.dest)) {
                if (!inMST[nextEdge.dest]) {
                    pq.offer(nextEdge);
                }
            }
        }

        return minSpanningTree;
    }

    public static void main(String[] args) {
        UndirectedGraph undirectedGraph = new UndirectedGraph(4);
        undirectedGraph.addEdge(0, 1, 10);
        undirectedGraph.addEdge(0, 2, 6);
        undirectedGraph.addEdge(0, 3, 5);
        undirectedGraph.addEdge(1, 0, 10);
        undirectedGraph.addEdge(1, 3, 15);
        undirectedGraph.addEdge(2, 0, 6);
        undirectedGraph.addEdge(2, 3, 4);
        undirectedGraph.addEdge(3, 0, 5);
        undirectedGraph.addEdge(3, 1, 15);
        undirectedGraph.addEdge(3, 2, 4);

        List<UndirectedEdge> mst = primMST(undirectedGraph);

        System.out.println("Edges in the Minimum Spanning Tree:");
        for (UndirectedEdge edge : mst) {
            System.out.println(edge.dest + " - " + edge.weight);
        }
    }
}
