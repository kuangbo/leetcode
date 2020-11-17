package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/17
 * Time: 上午11:04
 */
public class _21 {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (left < right && (nums[left] & 1) == 1)
                ++left;
            while (left < right && (nums[right] & 1) == 0)
                --right;
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}
