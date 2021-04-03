package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/18
 * Time: 下午3:26
 */
public class _offer_14_2 {
    public static void main(String[] args) {
        System.out.println(new Solution_14_2().cuttingRope(99));
    }
}

class Solution_14_2 {
    public int cuttingRope(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        long a = 1;
        while (n > 4) {
            a *= 3;
            a %= 1000000007;
            n -= 3;
        }
        return (int)(a * n % 1000000007 );
    }
}
