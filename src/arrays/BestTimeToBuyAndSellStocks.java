package arrays;

public class BestTimeToBuyAndSellStocks {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int maxProfit = Integer.MIN_VALUE;
        int l = 0, r = 0;

        while (r < prices.length) {
            if (prices[l] > prices[r]) {
                l = r;
            }
            maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            r++;
        }

        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int maxProfit = 0;
        int l = 0, r = 0;

        while (r < prices.length) {
            while (r < prices.length - 1 && prices[r + 1] >= prices[r]) {
                r++;
            }
            maxProfit += prices[r] - prices[l];
            while (r < prices.length - 1 && prices[r + 1] <= prices[r]) {
                r++;
            }
            l = r;
            r++;
        }

        return maxProfit;
    }


}
