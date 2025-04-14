package kahnsalgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//start with who has no dependency on any
//process them and decrement the no of dependency by one for each dependant, and if that dependant has no more dependency, queue it to be processed
public class CourseScheduler {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> neighbours = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            neighbours.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            neighbours.get(pre).add(course);
            indegree[course]++;
        }


        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int counts = 0;
        while (!queue.isEmpty()) {
            Integer pre = queue.poll();
            counts++;

            for (int course : neighbours.get(pre)) {
                indegree[course]--;
                if (indegree[course] == 0) {
                    queue.add(course);
                }
            }

        }
        return counts == numCourses;

    }

}
