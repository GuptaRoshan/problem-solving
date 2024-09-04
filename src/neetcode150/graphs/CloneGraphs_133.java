package neetcode150.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraphs_133 {

    /**
     * Definition for a Node.
     */
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * @param node   graph node
     * @param clones map of node values to their clones
     * @return Node
     */
    private Node cloneGraphDFSHelper(Node node, HashMap<Integer, Node> map) {
        // Create a new node and add it to the map
        map.put(node.val, new Node(node.val, new ArrayList<>()));
        // Iterate over the neighbors of the node
        // If the neighbor is not in the map, call the helper function recursively
        // Add the neighbor to the neighbor list of the current node
        for (Node currNode : node.neighbors) {
            if (!map.containsKey(currNode.val)) {
                cloneGraphDFSHelper(currNode, map);
            }

            map.get(node.val).neighbors.add(map.get(currNode.val));
        }

        return map.get(node.val);
    }

    Node cloneGraph(Node node) {
        HashMap<Integer, Node> clones = new HashMap<>();
        if (node == null) return null;
        return cloneGraphDFSHelper(node, clones);
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node1);
        node3.neighbors.add(node2);

        CloneGraphs_133 cloneGraphs_133 = new CloneGraphs_133();
        System.out.println(cloneGraphs_133.cloneGraph(node1));
    }

}

