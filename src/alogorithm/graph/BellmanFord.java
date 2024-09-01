package alogorithm.graph;

import alogorithm.graph.edge.DirectedEdge;
import alogorithm.graph.edge.Edge;

import java.util.Arrays;
import java.util.List;



public class BellmanFord {

    public static void bellmanFord(List<DirectedEdge> edges, int totalVertices, int source) {
        // Step 1: Initialize distances from source to all vertices as INFINITE
        int[] distances = new int[totalVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        // Step 2: Relax all edges vertices - 1 times
        for (int i = 1; i <= totalVertices - 1; ++i) {
            for (DirectedEdge edge : edges) {
                int src = edge.src; // u
                int dest = edge.dest; // v
                int weight = edge.weight; // w

                if (distances[src] != Integer.MAX_VALUE && distances[src] + weight < distances[dest]) {
                    distances[dest] = distances[src] + weight;
                }
            }
        }

        // Step 3: Check for negative-weight cycles
        for (DirectedEdge edge : edges) {
            int src = edge.src; // u
            int dest = edge.dest; // v
            int weight = edge.weight;// w

            if (distances[src] != Integer.MAX_VALUE && distances[src] + weight < distances[dest]) {
                System.out.println("Negative Cycle Detected");
            }
        }

        print(distances);
    }

    public static void print(int[] distances) {
        System.out.println("\nDistance from source vertex : 0");
        System.out.println("Vertex\tDistance");
        for (int i = 0; i < distances.length; ++i) {
            System.out.println(i + "\t\t" + distances[i]);
        }
    }

    public static void main(String[] args) {
        List<DirectedEdge> edges = Arrays.asList(
                new DirectedEdge(0, 1, 4),
                new DirectedEdge(0, 2, 5),
                new DirectedEdge(1, 2, -2),
                new DirectedEdge(1, 3, 8),
                new DirectedEdge(2, 3, 3),
                new DirectedEdge(3, 4, 1));
        bellmanFord(edges, 5, 0);
    }
}
