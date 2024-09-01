package alogorithm.graph;

import alogorithm.graph.edge.Edge;
import alogorithm.graph.edge.UndirectedEdge;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

    // Finds the shortest path from source to destination
    // Works for both directed and undirected graph
    public static void dijkstra(int src, UndirectedGraph graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(graph.totalVertices, (edge1, edge2) -> edge1.weight - edge2.weight);
        // Array to store the shortest distance from the source to each vertex
        int[] distance = new int[graph.totalVertices];
        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.add(new UndirectedEdge(src, 0));
        distance[src] = 0;

        while (!pq.isEmpty()) {
            int currentVertex = pq.poll().dest;
            for (Edge neighbour : graph.adjacencyList.get(currentVertex)) {
                // Calculate the new possible distance to the neighbor through the current vertex
                if (distance[currentVertex] + neighbour.weight < distance[neighbour.dest]) {
                    // If the new distance is shorter, update the distance array
                    distance[neighbour.dest] = distance[currentVertex] + neighbour.weight;
                    // Add the neighbor to the priority queue with the updated distance
                    pq.add(new UndirectedEdge(neighbour.dest, distance[neighbour.dest]));
                }
            }
        }

        print(distance);
    }

    public static void print(int[] distances) {
        System.out.println("\nDistance from source vertex : 0");
        System.out.println("Vertex\tDistance");
        for (int i = 0; i < distances.length; ++i) {
            System.out.println(i + "\t\t" + distances[i]);
        }
    }


    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 8);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 4, 9);
        graph.addEdge(3, 4, 4);
        dijkstra(0, graph);
    }


}
