package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecoverInverseCoinChange {
    int ways = 0;

    public List<Integer> findCoins(int[] numWays) {
        Set<Integer> coins = new HashSet<>();

        for (int amount = 1; amount <= numWays.length; amount++) {

            int ways = numWays[amount - 1];

            if (ways <= 0)
                continue;

            this.ways = ways;

            dfs(amount, numWays, new HashSet<>(), coins, new ArrayList<>());

            if (this.ways == 1) {
                coins.add(amount);
            }
            else if (this.ways > 0) {
                return new ArrayList<>();
            }

            this.ways = 0;

        }

        return new ArrayList<>(coins);
    }

    private void dfs(int amount, int[] numWays, Set<List<Integer>> allcombinations, Set<Integer> unique, List<Integer> orderedCoins) {
        if (ways == 0) {
            return;
        }

        if (amount == 0) {
            orderedCoins.sort(Integer::compareTo);
            if (allcombinations.add(orderedCoins)) {
                unique.addAll(orderedCoins);
                ways--;
            }
            return;
        }

        if (amount < 0) {
            return;
        }

        for (Integer i = 1; i <= amount; i++) {
            if (numWays[i - 1] == 0 || !unique.contains(i)) {
                continue;
            }

            orderedCoins.add(i);
            dfs(amount - i, numWays, allcombinations, unique, orderedCoins);
            orderedCoins.remove(i);

        }

    }

    public static void main(String[] args) {
        RecoverInverseCoinChange cc = new RecoverInverseCoinChange();
        cc.findCoins(new int[] {1,2,2,3,4});
    }
}
