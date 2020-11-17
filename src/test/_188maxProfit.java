package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/26
 * Time: 下午2:32
 */
public class _188maxProfit {
public int maxProfit(int k, int[] prices) {
    if (prices.length == 0)
        return 0;
    int n = prices.length;
    if (k > n / 2)  // 此时表示相当于没有约束，直接作为多次买卖处理
        return maxProfit_k_inf(prices);
    // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
    int[][][] dp = new int[n][k + 1][2];

    for (int i = 0; i < n; i++) {
        for (int j = k; j > 0; j--) {
            if (i - 1 == -1) {
                dp[i][j][0] = 0;
                dp[i][j][1] = -prices[i];
                continue;
            }
            dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
            dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
        }
    }
    return dp[n - 1][k][0];
}

public int maxProfit_k_inf(int[] prices) {
    if (prices.length == 0)
        return 0;
    int n = prices.length;
    // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
    int dp_i_0 = 0;
    int dp_i_1 = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
        int temp = dp_i_0;
        // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
        // dp[i][1] = max(dp[i-1][1], -prices[i])
        dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
    }
    return dp_i_0;
}
}
