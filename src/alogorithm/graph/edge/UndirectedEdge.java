package alogorithm.graph.edge;

// Concrete class for Edge without a source node (adjacency list style)
public class UndirectedEdge extends Edge {

    // Constructor for destination and weight
    public UndirectedEdge(int dest, int weight) {
        super(dest, weight);
    }
}
