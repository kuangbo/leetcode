package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/22
 * Time: 下午3:22
 */
public class _offer_39 {
    public int majorityElement(int[] nums) {
        // 摩尔投票法，一换一，最后活下来的都是值相同的
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0)
                res = num;
            if (num == res) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}
