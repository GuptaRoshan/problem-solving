package dataStructure.graph;

import java.util.Arrays;
import java.util.List;

class Edge {
    int source, destination, weight;

    Edge(int s, int d, int w) {
        source = s;
        destination = d;
        weight = w;
    }
}

public class BellmanFord {

    public static void print(int[] distances) {
        System.out.println("Vertex\tDistance from source");
        for (int i = 0; i < distances.length; ++i) {
            System.out.println(i + "\t\t" + distances[i]);
        }
    }

    public static void bellmanFord(List<Edge> edges, int vertices, int source) {
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
                System.out.println("The problems.graph contains a negative-weight cycle");
                return;
            }
        }

        // Step 4: Print the shortest path from source to all vertices
        print(distances);
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
        bellmanFord(edges, vertices, source);
    }
}
