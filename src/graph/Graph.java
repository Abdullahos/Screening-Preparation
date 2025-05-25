package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
    int val;
    Graph parent;
    Set<Graph> children;

    public Graph() {
    }

    public Graph(int val) {
        this.val = val;
    }

    public Set<Graph> getChildren() {
        return children == null ? new HashSet<>() : children;
    }
}
