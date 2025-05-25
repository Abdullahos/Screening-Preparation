package graph;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        Map<Integer, Graph> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int parent = prerequisite[1];

            Graph node = map.getOrDefault(course, new Graph(course));
            Graph parentNode = map.getOrDefault(parent, new Graph(parent));

            Set<Graph> children = parentNode.getChildren();
            children.add(node);
            parentNode.children = children;

            map.putIfAbsent(course, node);
            map.putIfAbsent(parent, parentNode);

            node.parent = parentNode;
        }

        List<Graph> roots = findRoots(map);
        if (roots == null || roots.isEmpty()) {
            return false;
        }

        for (Graph root : roots) {
            Set<Integer> visited = new HashSet<>();
            if (validateIfCycle(root, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateIfCycle(Graph root, Set<Integer> visited) {
        for (Graph child : root.getChildren()) {
            if (visited.contains(child.val)) {
                return false;
            }
            visited.add(child.val);
            if (validateIfCycle(child, visited)) {
                return false;
            }
            visited.remove(child.val);
        }
        return true;
    }

    private List<Graph> findRoots(Map<Integer, Graph> map) {
        List<Graph> roots = new ArrayList<>();
        if (map.isEmpty()) {
            return null;
        }

        for (Map.Entry<Integer, Graph> entry : map.entrySet()) {
            if (entry.getValue().parent == null) {
                roots.add(entry.getValue());
            }
        }

        return roots;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        cs.canFinish(2, new int[][] {{1,0}});
    }
}
