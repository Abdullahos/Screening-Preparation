package arrays;

public class MinCuttingCost {

    public long minCuttingCost(int n, int m, int k) {
        int max = Math.max(n, m);

        if (k >= max) {
            return 0;
        }

        long i = 1;
        for (; i <= k; i++) {
            if (max - i == k) {
                break;
            }
        }

        return i * k;

    }

}
