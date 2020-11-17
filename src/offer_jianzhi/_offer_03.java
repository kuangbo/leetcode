package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/10/23
 * Time: 上午10:44
 */
public class _offer_03 {
    public int findRepeatNumber(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]])
                    return nums[i];
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;

            }
        }
        return -1;
    }
}
