package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/26
 * Time: 下午2:54
 */
public class _123maxProfit {
public int maxProfit(int[] prices) {
    if (prices.length == 0)
        return 0;
    int n = prices.length;
    int max_k = 2;
    // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
    int[][][] dp = new int[n][max_k + 1][2];

    for (int i = 0; i < n; i++) {
        for (int k = max_k; k > 0; k--) {
            if (i - 1 == -1) {  // 处理base case
                dp[i][k][0] = 0;
                dp[i][k][1] = -prices[i];
                continue;
            }
            dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
            dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
        }
    }
    return dp[n - 1][max_k][0];
}
}
