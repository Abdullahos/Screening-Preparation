package algorithms.graph.topologicalsort;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CourseScheduler {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Node> nodes = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        AtomicInteger nums = new AtomicInteger();

        for (int[] pair : prerequisites) {
            Node dep = new Node(pair[0]);
            Node pre = new Node(pair[1]);

            if (nodes.containsKey(dep.label)) {
                dep = nodes.get(dep.label);
                dep.pres.add(pre);
            } else {
                dep.pres.add(pre);
                nodes.put(dep.label, dep);
                nums.getAndIncrement();
            }

            if (nodes.containsKey(pre.label)) {
                pre = nodes.get(pre.label);
                pre.deps.add(dep);
            } else {
                pre.deps.add(dep);
                nodes.put(pre.label, pre);
                nums.getAndIncrement();
            }
        }

        nodes.values().stream().filter(node -> node.pres.isEmpty()).forEach(node -> {
            pq.offer(node);
            nums.getAndDecrement();
        });

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            numCourses--;

            cur.deps.forEach(dep -> {
                dep.pres.remove(cur);

                if (dep.pres.isEmpty()) {
                    pq.add(dep);
                    nums.getAndDecrement();
                }
            });
        }

        return nums.get() == 0;
    }
}

class Node implements Comparable<Node> {
    int label;
    Set<Node> pres;
    Set<Node> deps;

    public Node(int label) {
        this.label = label;
        pres = new HashSet<Node>();
        deps = new HashSet<Node>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return label == node.label;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(pres.size(), o.pres.size());
    }


    public static void main(String[] args) {
        CourseScheduler cs = new CourseScheduler();
        int[][] arr = {
                {1, 0},
                {0, 3},
                {0, 2},
                {3, 2},
                {2, 5},
                {4, 5},
                {5, 6},
                {2, 4}
        };

        int[][] arr2= {
                {1, 4},
                {2, 4},
                {3, 1},
                {3, 2}
        };

        int[][] arr3 = {
                {0, 10},
                {3, 18},
                {5, 5},
                {6, 11},
                {11, 14},
                {13, 1},
                {15, 1},
                {17, 4}
        };

        int[][] arr4 = {
                {2,0},{2,1}
        };

        cs.canFinish(3, arr4);
    }
}

