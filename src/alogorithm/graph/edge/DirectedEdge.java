package alogorithm.graph.edge;


// Concrete class for Edge with source node
public class DirectedEdge extends Edge {
    public int src;

    // Constructor for a source, destination, and weight
    public DirectedEdge(int src, int dest, int weight) {
        super(dest, weight);
        this.src = src;
    }
}
