package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/25
 * Time: 下午7:11
 */
public class _offer_56_1 {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        // 得到异或结果，即为不相同两个数的异或结果sum
        for (int num : nums) {
            sum ^= num;
        }
        // 得到sum的二进制的1的最低位
        int flag = (-sum) & sum;
        int[] res = new int[2];
        // 分成两个组进行异或，每组异或后的结果就是不相同两个数的其中之一
        for (int num : nums) {
            if ((flag & num) == 0)
                res[0] ^= num;
            else
                res[1] ^= num;
        }
        return res;
    }
}
