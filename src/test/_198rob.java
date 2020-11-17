package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/28
 * Time: 上午10:29
 */
public class _198rob {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 1, 2};
        rob(nums);
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            // base case
            if (i - 2 == -2) {
                dp[i] = nums[i];
                continue;
            } else if (i - 2 == -1) {
                dp[i] = Math.max(nums[i], dp[i - 1]);
                continue;
            }
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }
}
