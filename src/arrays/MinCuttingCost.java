package arrays;

public class MinCuttingCost {

    public long minCuttingCost(int n, int m, int k) {
        if (Math.max(n, m) <= k) {
            return 0;
        }

        return ((long) (Math.max(n, m) - k)) * k;
    }

    //no need to do so, as no container can hold more than one log, and it's granted to fit as
    //the problem stated, so the min one will absolutely fit and the max maybe, so we can rely on this formula ((long) (Math.max(n, m) - k)) * k
    public long minCuttingCost2(int n, int m, int k) {
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
