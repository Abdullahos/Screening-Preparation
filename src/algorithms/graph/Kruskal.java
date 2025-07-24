package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

    List<Integer> mst;

    public Kruskal() {
        this.mst = new  ArrayList<>();
    }

    public List<Integer> reduce(int n, int[][] vertex) {
        DisjointSet disjointSet = new DisjointSet(n);

        //sort asc
        Arrays.sort(vertex, Comparator.comparingInt(a -> a[2]));

        //for each vertx (u,v):
        for  (int[] vertx : vertex) {
            int u = vertx[0],  v = vertx[1], w = vertx[2];
            if (disjointSet.union(u, v)) {
                mst.add(w);
            }
        }

        return mst;
    }

}
