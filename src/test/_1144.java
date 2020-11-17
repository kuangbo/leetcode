package test;

import java.util.Arrays;

public class _1144 {
    public static void main(String[] args) {
    }

    public int movesToMakeZigzag(int[] nums) {
        return Math.min(process(Arrays.copyOf(nums, nums.length), 0), process(nums, 1));
    }

    public int process(int[] nums, int j) {
        int count = 0;
        for (; j < nums.length; j += 2) {
            if (j > 0 && nums[j] <= nums[j - 1]) {
                count += nums[j - 1] - nums[j] + 1;
                nums[j - 1] = nums[j] - 1;
            }
            if (j < nums.length - 1 && nums[j] <= nums[j + 1]) {
                count += nums[j + 1] - nums[j] + 1;
                nums[j + 1] = nums[j] - 1;
            }
        }
        return count;
    }
}
