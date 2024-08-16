package dataStructure.graph;

import java.util.Arrays;
import java.util.List;



public class BellmanFord {

    public static void print(int[] distances) {
        System.out.println("Vertex\tDistance from source");
        for (int i = 0; i < distances.length; ++i) {
            System.out.println(i + "\t\t\t" + distances[i]);
        }
    }

    private static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int s, int d, int w) {
            source = s;
            destination = d;
            weight = w;
        }
    }

    public int[] bellmanFord(List<Edge> edges, int vertices, int source) {
        // Step 1: Initialize distances from source to all vertices as INFINITE
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        // Step 2: Relax all edges |vertices| - 1 times
        for (int i = 1; i <= vertices - 1; ++i) {
            for (Edge e : edges) {
                int u = e.source;
                int v = e.destination;
                int weight = e.weight;
                if (distances[u] != Integer.MAX_VALUE && distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                }
            }
        }

        // Step 3: Check for negative-weight cycles
        for (Edge e : edges) {
            int u = e.source;
            int v = e.destination;
            int weight = e.weight;
            if (distances[u] != Integer.MAX_VALUE && distances[u] + weight < distances[v]) {
                return new int[0];
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 4),
                new Edge(0, 2, 5),
                new Edge(1, 2, -2),
                new Edge(1, 3, 8),
                new Edge(2, 3, 3),
                new Edge(3, 4, 1));
        int vertices = 5;
        int source = 0;
        print(new BellmanFord().bellmanFord(edges, vertices, source));
    }
}
