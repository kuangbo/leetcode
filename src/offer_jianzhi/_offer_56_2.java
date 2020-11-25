package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/25
 * Time: 下午7:11
 */
public class _offer_56_2 {
    public static void main(String[] args) {
        int a = 15;
        System.out.println(a & 1);
        System.out.println(~a);
    }

    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            a = (a ^ num) & (~b);
            b = (b ^ num) & (~a);
            System.out.println(a + "-----" + b);
        }
        return a;
    }
}
