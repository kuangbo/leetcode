package test;

public class _674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        int len = 0;
        int right = 1;
        int res = 0;

        while (right < nums.length) {
            if (nums[right] <= nums[right - 1]) {
                res = Math.max(res, len);
                len = 0;
            } else {
                len++;
            }
            right++;
        }
        // 最后再执行一次max，防止len++之后并未计算在内
        res = Math.max(res, len) + 1;
        return res;
    }
}
