package offer_jianzhi;

public class _offer_53 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        // 左闭右闭区间
        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == nums[mid])   // 当mid与当前数字相等时，表示缺失数字在右边
                left = mid + 1;
            else    // 不相等时表示，缺失数字在左边
                right = mid - 1;
        }
        return left;
    }
}
