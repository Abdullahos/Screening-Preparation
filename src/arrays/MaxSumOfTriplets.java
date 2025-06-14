package arrays;

import java.util.*;

public class MaxSumOfTriplets {

    public int maxSumDistinctTriplet(int[] x, int[] y) {
        Map<Integer, Integer> bestYForX = new HashMap<>();

        for (int i = 0; i < x.length; i++) {
            bestYForX.put(x[i], Math.max(bestYForX.getOrDefault(x[i], 0), y[i]));
        }

        List<Integer> bestYValues = new ArrayList<>(bestYForX.values());

        if (bestYValues.size() < 3) return -1;

        bestYValues.sort(Collections.reverseOrder());

        return bestYValues.get(0) + bestYValues.get(1) + bestYValues.get(2);
    }

}
