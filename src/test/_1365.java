package test;

public class _1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arrays = new int[101];
        for (int num : nums)
            arrays[num] += 1;
        for (int i = 1; i < arrays.length; i++)
            arrays[i] += arrays[i - 1];
        for (int i = 0; i < nums.length; i++)
            nums[i] = nums[i] != 0 ? arrays[nums[i] - 1] : 0;
        return nums;
    }
}
