package backtracking;

import java.util.HashSet;
import java.util.Set;

public class MaxSumOfTriplets {
    int max = 0;

    public int maxSumDistinctTriplet(int[] x, int[] y) {
        dfs(x, y, new HashSet<>(), 0, 0);
        return max == 0 ? - 1: max;
    }

    private void dfs(int[] x, int[] y, Set<Integer> triplet, int start, int sum) {
        if (triplet.size() == 3) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = start; i < x.length; i++) {
            if (triplet.contains(x[i])) {
                continue;
            }

            sum += y[i];

            triplet.add(x[i]);

            dfs(x, y, triplet, i + 1, sum);

            sum -= y[i];

            triplet.remove(x[i]);
        }
    }
}
