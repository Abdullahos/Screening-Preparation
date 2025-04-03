package arrays;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int buyIdx = 0;
        int sellIdx = 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <  prices[buyIdx]) buyIdx = i;
            if (prices[i] > prices[buyIdx]) sellIdx = i;
            if (buyIdx < sellIdx) {
                maxProfit = Math.max(maxProfit, prices[sellIdx] - prices[buyIdx]);
            }
        }

        return maxProfit;
    }
}
