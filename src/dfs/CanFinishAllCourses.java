package dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CanFinishAllCourses {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>(numCourses);
        Map<Integer, Set<Integer>> preMap = new HashMap<>(numCourses);

        for (int[] pairs : prerequisites) {
            int course = pairs[0];
            int pre = pairs[1];

            Set<Integer> set = map.getOrDefault(course, new HashSet<>());

            if (set.contains(course)) {
                return false;
            }

            set.add(pre);
            map.put(course, set);
        }

        return isValid(map, preMap);

    }

    private boolean isValid(Map<Integer, Set<Integer>> map, Map<Integer, Set<Integer>> preMap) {

        Set<Integer> stk = new HashSet<>();

        for (int course : map.keySet()) {
            if (isCyclic(map, preMap, stk, course)) {
                return false;
            }
        }

        return true;

    }

    private boolean isCyclic(Map<Integer, Set<Integer>> map, Map<Integer, Set<Integer>> preMap, Set<Integer> stk, int course) {
        if (preMap.containsKey(course)) {
            Set<Integer> pres = preMap.get(course);
            for (int pre : pres) {
                if (stk.contains(pre)) {
                    return true;
                }
            }
            return false;
        }

        if (stk.contains(course)) {
            return true;
        }

        stk.add(course);

        Set<Integer> pres = map.getOrDefault(course, new HashSet<>());

        for (int pre : pres) {
            if (stk.contains(pre)) {
                return true;
            }
        }

        for (int pre : pres) {
            if (isCyclic(map, preMap, stk, pre)) {
                return true;
            }
        }

        stk.remove(course);
        stk.removeAll(pres);

        preMap.put(course, pres);


        return false;

    }
}
