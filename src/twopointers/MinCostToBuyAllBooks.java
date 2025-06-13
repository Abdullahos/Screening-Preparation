package twopointers;

public class MinCostToBuyAllBooks {

    //not sorted, t: O(3^n), s: O(n)
    public int minCostToBuy(int[] cost, int pairCost, int k) {
        return dfs(cost, k, 0, cost.length - 1, pairCost);
    }

    private int dfs(int[] cost, int k, int left, int right, int pairCose) {
        if (left == right) {
            return cost[left];
        }

        if (left > right) {
            return 0;
        }

        int buyLeft = cost[left] + dfs(cost, k, left + 1, right, pairCose);

        int buyRight = cost[right] + dfs(cost, k, left, right - 1, pairCose);

        int buyPair = k > 0 ? pairCose + dfs(cost, k - 1, left + 1, right - 1, pairCose) : Integer.MAX_VALUE;

        return Math.min(buyLeft, Math.min(buyRight, buyPair));
    }

    //if sorted
    public int minCost(int[] cost, int pairCost, int k) {
        int sum = 0;

        int i = 0, j = cost.length - 1;
        for (; i < cost.length - 2 * k; i++) {
            sum += cost[i];
        }

        while (i < j) {

            if (cost[i] < pairCost) {
                sum += cost[i];
                i++;
            } else {
                sum += pairCost;
                i++;
                j--;
            }

        }

        if (i == j) {
            sum += cost[j];
        }

        return sum;
    }

}
