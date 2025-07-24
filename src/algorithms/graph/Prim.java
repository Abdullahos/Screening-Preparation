package algorithms.graph;

import java.util.*;

//vertx:
public class Prim {

    private Queue<Edge> queue;
    private Set<Integer> mst;

    public Prim() {
        this.queue = new PriorityQueue<>();
        this.mst = new HashSet<>();
    }

    int getMST(int[][] edges) {
        int x = 0, y = 0, min = Integer.MAX_VALUE;
        int cost = 0;
        boolean[] visited = new boolean[edges.length + 1];

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length; j++) {
                if (edges[i][j] < min) {
                    min = edges[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        queue.add(new Edge(x, y, min));
        visited[x] = true;
        visited[y] = true;

        while (!queue.isEmpty()) {
            Edge edge = queue.remove();
            int v = edge.v;
            int u = edge.u;
            int w = edge.w;


            addChildren(edges, visited, u, v);  //add u children

            addChildren(edges, visited, v, u);  //add v children

            visited[v] = true;
            visited[u] = true;

            mst.add(w);

            cost += w;
        }


        return cost;
    }

    private void addChildren(int[][] edges, boolean[] visited, int v, int u) {
        for (int i = 0; i < edges[v].length; i++) {
            if (!visited[i] && i != u && edges[v][i] > 0) {
                queue.add(new Edge(v, i, edges[v][i]));
            }
        }
    }
}

class Edge implements Comparable<Edge> {

    int u, v, w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.w, o.w);
    }

}
