package algorithms.graph.topologicalsort;

import java.util.ArrayList;
import java.util.List;

//Topological sort
public class CourseScheduler2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int dep = pair[1];

            adj.get(course).add(dep);
        }

        boolean[] path = new boolean[numCourses];
        boolean isCyclic = false;

        for (int i = 0; i < numCourses; i++) {
            isCyclic = visit(adj, i, visited, path, order);
            if (isCyclic) {
                return new int[] {};
            }
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = order.get(i);
        }

        return res;
    }

    private boolean visit(List<List<Integer>> adj, int course, boolean[] visited, boolean[] path, List<Integer> order) {
        if (path[course]) {
            return true;
        }

        if (visited[course]) {
            return false;
        }

        path[course] = true;

        visited[course] = true;

        boolean isCyclic;

        for (int dep : adj.get(course)) {
            isCyclic = visit(adj, dep, visited, path, order);
            if (isCyclic) {
                return true;
            }
        }

        order.add(course);

        path[course] = false;

        return false;
    }
}
