package arrays;

import java.util.*;

public class RecoverInverseCoinChange {
    public List<Integer> findCoins(int[] numWays) {
        int n = numWays.length;
        List<Integer> coins = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            if (coins.size() == 0 && numWays[i - 1] == 1) {
                coins.add(i);
            } else {
                int actualWays = getActualWays(i, coins, 0, new HashMap<>());
                if (actualWays == numWays[i - 1]) {
                }
                else if (actualWays + 1 == numWays[i - 1]) {
                    coins.add(i);
                } else {
                    return new ArrayList<>();
                }
            }
        }

        return coins;
    }

    private int getActualWays(int amount, List<Integer> coins, int start, Map<String, Integer> memo) {
        if (amount == 0) {
            return 1;
        }

        if (amount < 0) {
            return 0;
        }

        String key = amount + ":" + start;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int ways = 0;

        for (int i = start; i < coins.size(); i++) {
            ways += getActualWays(amount - coins.get(i), coins, i, memo);
        }

        memo.put(key, ways);

        return ways;
    }
}
