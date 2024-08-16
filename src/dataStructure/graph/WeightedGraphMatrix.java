package dataStructure.graph;

@SuppressWarnings("all")
class WeightedGraphMatrix {
    private final int vertices;
    private final int[][] adjacencyMatrix;

    // Constructor
    public WeightedGraphMatrix(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    // Add an edge from source to destination the graph
    public void addEdge(int source, int destination, int weight) {
        // add the edge
        adjacencyMatrix[source][destination] = weight;
        // For undirected graph, add the reverse edge
        adjacencyMatrix[destination][source] = weight;
    }


    public static void main(String[] args) {
        WeightedGraphMatrix graph = new WeightedGraphMatrix(5);

        graph.addEdge(0, 1, 30);
        graph.addEdge(0, 3, 40);
        graph.addEdge(1, 2, 50);
        graph.addEdge(2, 3, 60);
    }
}
