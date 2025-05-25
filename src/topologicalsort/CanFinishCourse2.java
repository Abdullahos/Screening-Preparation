package topologicalsort;

import java.util.*;

public class CanFinishCourse2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int n = prerequisites.length;

        if (n == 0) {
            int[] order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = i;
            }
            return order;
        }

        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stk = new Stack<>();
        Set<Integer> path = new HashSet<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] pairs : prerequisites) {
            int course = pairs[0];
            int pre = pairs[1];

            List<Integer> pres = map.getOrDefault(course, new ArrayList<>());
            pres.add(pre);

            map.put(course, pres);
        }

        for (int course = 0; course < numCourses; course++) {
            if (!visit(map, visited, stk, course, path)) {
                return new int[0];  // cycle detected
            }
        }

        int[] result = new int[numCourses];
        for (int i = numCourses - 1; i >= 0; i--) {
            result[i] = stk.pop();
        }

        return result;

    }

    private boolean visit(Map<Integer, List<Integer>> map, boolean[] visited, Stack<Integer> stk, int course, Set<Integer> path) {
        if (path.contains(course)) {
            return false;
        }

        if (visited[course]) {
            return true;
        }

        path.add(course);
        visited[course] = true;

        List<Integer> pres = map.getOrDefault(course, new ArrayList<>());

        for (int pre : pres) {
            if (!visit(map, visited, stk, pre, path)) {
                return false;
            }
        }

        stk.push(course);
        path.remove(course);

        return true;
    }
}
