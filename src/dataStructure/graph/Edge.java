package dataStructure.graph;


class Edge {
    int destination;
    int weight;

    Edge(int node, int weight) {
        this.destination = node;
        this.weight = weight;
    }
}