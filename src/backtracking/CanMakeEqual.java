package backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CanMakeEqual {
    public boolean canMakeEqual(int[] nums, int k) {
        Set<String> visited = new HashSet<>();
        return dfs(nums, k, 0, -1, visited);
    }

    boolean dfs(int[] nums, int k, int counter, int lastI, Set<String> visited) {

        String state = buildState(nums, counter);

        if (!visited.add(state)) {
            return false;
        }

        if (counter > k) {
            return false;
        }

        if (allEqual(nums)) {
            return true;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (i == lastI) {
                continue;
            }

            mult(nums, i);

            if (dfs(nums, k, counter + 1, i, visited)) {
                return true;
            }

            mult(nums, i);
        }

        return false;
    }

    void mult(int[] nums, int i) {
        if (i + 1 < nums.length) {
            nums[i] *= -1;
            nums[i + 1] *= -1;
        }
    }

    boolean allEqual(int[] nums) {
        int first = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != first) {
                return false;
            }
        }

        return true;
    }

    String buildState(int[] array, int counter) {

        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num);
        }

        sb.append(counter);

        return sb.toString();
    }

    class BFS_Solution {

        boolean canMakeEqual(int[] nums, int k) {
            Queue<State> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            queue.offer(new State(0, nums.clone()));
            visited.add(buildState(nums, k));

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    State state = queue.poll();

                    int[] arr = state.arr;
                    int counter = state.counter;

                    if (allEqual(arr)) {
                        return true;
                    }

                    if (counter == k) {
                        continue;
                    }

                    for (int j = 0; j < arr.length - 1; j++) {
                        int[] copy = arr.clone();
                        copy[j] *= -1;
                        copy[j + 1] *= -1;

                        if (allEqual(copy)) {
                            return true;
                        }

                        if (!visited.add(buildState(copy, counter))) {
                            queue.offer(new State(counter + 1, copy));
                        }

                    }
                }
            }

            return false;
        }


        class State {
            int counter;
            int[] arr;

            public State(int counter, int[] arr) {
                this.counter = counter;
                this.arr = arr;
            }
        }

    }
}
