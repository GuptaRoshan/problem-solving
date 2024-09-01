package alogorithm.graph.edge;

// Base Edge class
public abstract class Edge {
    public int dest;
    public int weight;

    // Constructor for destination and weight
    public Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}