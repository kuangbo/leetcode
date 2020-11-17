package test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/16
 * Time: 下午2:02
 */
public class _27removeElement {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
//        int[] nums = new int[]{};
        int val = 2;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        int foot = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != val) {
                nums[foot] = nums[i];
                foot++;
            }
            i++;
        }
        return foot;
    }
}
