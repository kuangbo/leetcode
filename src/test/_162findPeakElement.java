package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/4/13
 * Time: 下午8:34
 */
public class _162findPeakElement {
    public static void main(String[] args) {
        System.out.println(new Solution_162().findPeakElement(new int[]{1, 2, 3, 4, 1}));
    }
}

class Solution_162 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1])
                right = mid;
            else
                left = mid;
        }
        return left;
    }
}
