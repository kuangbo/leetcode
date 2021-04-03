package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/16
 * Time: 下午1:31
 */
public class _offer_63 {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new Solution_63().maxProfit(prices));
    }
}

class Solution_63 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        // 简化dp数组
        int dp_i_0 = 0; // 当天买入
        int dp_i_1 = 0; // 当天卖出
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp_i_0 = prices[i];
                dp_i_1 = 0;
                continue;
            }
            dp_i_0 = Math.min(dp_i_0, prices[i]); // 比较，寻找最低买入价格
            dp_i_1 = Math.max(Math.max(prices[i] - dp_i_0, 0), dp_i_1); // 最高卖出
        }
        return dp_i_1;
    }
}
