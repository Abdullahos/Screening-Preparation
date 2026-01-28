package graph;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/clone-graph
public class CloneGraph {

    Map<Integer, Node> node_poles = new HashMap<>();

    //t: O(n), s: O(d), where d is the avg depth of the graph
    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        if (node_poles.containsKey(node.val)) {
            return node_poles.get(node.val);
        }

        Node node_clone = new Node(node.val);
        node_poles.put(node.val, node_clone);

        for (Node nigh : node.neighbors) {
            Node nigh_clone = cloneGraph(nigh);
            node_clone.neighbors.add(nigh_clone);
        }

        return node_clone;
    }
}


