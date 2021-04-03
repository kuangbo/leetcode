package gongzizhenti;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/12/4
 * Time: 上午10:08
 */
public class test {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 1, 1, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    /**
     * 删除一个数，求最大连续1的个数
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int dp1 = 0;
        int dp0 = 0;
        int res = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                dp1 = dp1 + 1;
                dp0 = dp0 + 1;
            } else {
                dp1 = dp0 + 1;
                dp0 = 0;
            }
            res = Math.max(dp1, Math.max(res, dp0));
        }
        return res;
    }
}
