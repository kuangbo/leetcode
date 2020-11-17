package test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/16
 * Time: 下午1:40
 */
public class _26removeDuplicates {
    public static void main(String[] args) {
//        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums = new int[]{1, 1};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int foot = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[foot] != nums[i]) {
                foot++;
                nums[foot] = nums[i];
            }
        }
        return foot + 1;
    }
}
