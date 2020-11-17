package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/28
 * Time: 上午10:29
 */
public class _213rob {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        // 两种情况，第一种取第一个，第二种不取第一个
        // 对应nums数组[0, len-2]和[1, len-1]
        int[][] dp = new int[len][2];

        for (int i = 0; i < len; i++) {
            if (i - 2 == -2) {
                dp[i][0] = 0;
                dp[i][1] = nums[i];
                continue;
            } else if (i - 2 == -1) {
                dp[i][0] = nums[i];
                dp[i][1] = Math.max(nums[i], dp[i - 1][1]);
                continue;
            } else if (i == len - 1) {
                dp[i][0] = Math.max(dp[i - 2][0] + nums[i], dp[i - 1][0]);
                dp[i][1] = dp[i - 1][1];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 2][0] + nums[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 2][1] + nums[i], dp[i - 1][1]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
