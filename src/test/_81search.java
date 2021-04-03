package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/28
 * Time: 上午9:41
 */
public class _81search {
    public static void main(String[] args) {
        System.out.println(new Solution_81().search(new int[]{1}, 0));
    }
}

class Solution_81 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0)
            return false;
        int left = 0, right = nums.length - 1;
        while (left < right && nums[left] == nums[right])
            right--;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[left] || target == nums[mid] || target == nums[right])
                return true;
            if (nums[left] <= nums[mid]) {
                if (target > nums[left] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (nums[left] > nums[mid]) {
                if (target < nums[right] && target > nums[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return false;
    }
}
