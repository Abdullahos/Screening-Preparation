package algorithms.graph.topologicalsort;

import java.util.*;

//IF numCourses courses you have to take, labeled from 0 to numCourses - 1,
// then we can get adv of knowing the size of depOnMe & weights so we don't need map/Node class to hold the dep/pre relation anymore
public class CourseScheduler {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> depOnMe = new ArrayList<>();
        int[] weights = new int[numCourses];
        Queue<Integer> pq = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            depOnMe.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int dep = pair[0];
            int pre = pair[1];

            List<Integer> deps = depOnMe.get(pre);
            deps.add(dep);

            weights[dep]++; //how many courses i depends on
        }

        for (int i = 0; i < weights.length; i++) {
            if (weights[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int course = pq.poll();
            numCourses--;

            List<Integer> deps = depOnMe.get(course);

            deps.forEach(dep -> {
                if (--weights[dep] == 0) {
                    pq.add(dep);
                }
            });

        }

        return numCourses == 0;
    }

    //slower to hashing overhead
    public boolean canFinishSlower(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> whoDependingOnMe = new HashMap<>();

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int pre = pair[1];

            List<Integer> dependings = whoDependingOnMe.getOrDefault(pre, new ArrayList<>());
            dependings.add(course);
            whoDependingOnMe.put(pre, dependings);

            inDegree[course]++;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.remove();
            List<Integer> dependings = whoDependingOnMe.getOrDefault(course, new ArrayList<>());

            for (int dep : dependings) {
                if (--inDegree[dep] == 0) {
                    queue.add(dep);
                }
            }

            numCourses--;

        }

        return numCourses == 0;
    }
}
