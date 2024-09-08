package priv.cxs.classic150;

public class Question146 {
    public int maxProfit(int[] prices) {
        return maxProfit(2, prices);
    }

    private int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // 1 卖出 , 0 买入
        int[][][] dp = new int[prices.length][2][k];
        dp[0][0][0] = -prices[0];
        dp[0][1][0] = 0;
        for (int i = 0; i < k; i++) {
            dp[0][0][i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], -prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] + prices[i]);
            for (int j = 1; j < k; j++) {
                dp[i][0][j] = Math.max(dp[i - 1][1][j - 1] - prices[i], dp[i - 1][0][j]);
                dp[i][1][j] = Math.max(dp[i - 1][0][j] + prices[i], dp[i - 1][1][j]);
            }
        }
        return dp[prices.length - 1][1][k - 1];
    }
}
