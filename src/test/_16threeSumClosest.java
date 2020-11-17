package test;

import java.util.Arrays;

class _16threeSumClosest {
    public static void main(String[] args) {
        int [] nums = new int[]{-1,2,1,-4};
        System.out.println(new _16threeSumClosest().threeSumClosest(nums, 1));
    }

    private int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - res))
                    res = sum;
                if (sum > target)
                    end--;
                else if (sum < target)
                    start++;
                else
                    return res;
            }
        }
        return res;
    }
}
