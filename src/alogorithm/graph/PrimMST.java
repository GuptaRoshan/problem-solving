package alogorithm.graph;

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
    public static List<UndirectedEdge> primMST(List<List<UndirectedEdge>> graph) {
        int V = graph.size();

        List<UndirectedEdge> minSpanningTree = new ArrayList<>();

        boolean[] inMST = new boolean[V];
        PriorityQueue<UndirectedEdge> pq = new PriorityQueue<>((edge1, edge2) -> edge1.weight - edge2.weight);

        // Start with vertex 0
        inMST[0] = true;
        pq.addAll(graph.getFirst());

        while (!pq.isEmpty()) {
            UndirectedEdge edge = pq.poll();

            if (inMST[edge.dest]) continue;

            inMST[edge.dest] = true;
            minSpanningTree.add(edge);

            for (UndirectedEdge nextEdge : graph.get(edge.dest)) {
                if (!inMST[nextEdge.dest]) {
                    pq.offer(nextEdge);
                }
            }
        }

        return minSpanningTree;
    }

    public static void main(String[] args) {
        int V = 4;

        List<List<UndirectedEdge>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        graph.get(0).add(new UndirectedEdge(1, 10));
        graph.get(0).add(new UndirectedEdge(2, 6));
        graph.get(0).add(new UndirectedEdge(3, 5));
        graph.get(1).add(new UndirectedEdge(0, 10));
        graph.get(1).add(new UndirectedEdge(3, 15));
        graph.get(2).add(new UndirectedEdge(0, 6));
        graph.get(2).add(new UndirectedEdge(3, 4));
        graph.get(3).add(new UndirectedEdge(0, 5));
        graph.get(3).add(new UndirectedEdge(1, 15));
        graph.get(3).add(new UndirectedEdge(2, 4));

        List<UndirectedEdge> mst = primMST(graph);

        System.out.println("Edges in the Minimum Spanning Tree:");
        for (UndirectedEdge edge : mst) {
            System.out.println(edge.dest + " - " + edge.weight);
        }
    }
}
