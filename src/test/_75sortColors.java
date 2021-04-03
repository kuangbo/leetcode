package test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/29
 * Time: 下午6:43
 */
public class _75sortColors {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_75().sortColors(new int[]{2, 0,1})));
    }
}

class Solution_75 {
    public int[] sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, index = 0;
        while (index <= right) {
            if (nums[index] == 1) {
                index ++;
            } else if (nums[index] == 0) {
                swap(nums, left, index);
                left++;
                index++;
            } else {
                swap(nums, right, index);
                right--;
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
