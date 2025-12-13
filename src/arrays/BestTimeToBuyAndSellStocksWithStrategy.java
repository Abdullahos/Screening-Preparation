package arrays;

public class BestTimeToBuyAndSellStocksWithStrategy {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long originalProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            originalProfit += (long) prices[i] * strategy[i];
        }

        long profit = originalProfit, max;

        int l = 0, mid = k / 2, r = k - 1;

        for (int i = l; i < k; i++) {
            if (i < mid) {
                profit -= (long) prices[i] * strategy[i];  // * 0
            } else {
                profit += prices[i] - ((long) prices[i] * strategy[i]);  // *1 - original
            }
        }

        max = Math.max(profit, originalProfit);

        l++; mid++; r++;

        while (r < prices.length) {

            profit -= prices[mid - 1];
            profit += (long) prices[l - 1] * strategy[l - 1];
            profit += prices[r] - ((long) prices[r] * strategy[r]);

            max = Math.max(max, profit);
            l++; mid++; r++;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{4,7,13};
        int[] strategy = new int[]{-1,-1,0};

        int k = 2;
        BestTimeToBuyAndSellStocksWithStrategy  test = new BestTimeToBuyAndSellStocksWithStrategy();
        System.out.println(test.maxProfit(prices, strategy, k));

    }
}
