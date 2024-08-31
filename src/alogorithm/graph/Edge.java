package alogorithm.graph;


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

// Concrete class for Edge with source node
class DirectedEdge extends Edge {
    public int src;

    // Constructor for a source, destination, and weight
    public DirectedEdge(int src, int dest, int weight) {
        super(dest, weight);
        this.src = src;
    }
}

// Concrete class for Edge without a source node (adjacency list style)
class UndirectedEdge extends Edge {

    // Constructor for destination and weight
    public UndirectedEdge(int dest, int weight) {
        super(dest, weight);
    }
}