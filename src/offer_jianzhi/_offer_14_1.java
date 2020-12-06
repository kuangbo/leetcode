package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/12/3
 * Time: 下午6:50
 */
public class _offer_14_1 {
    public int cuttingRope(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int a = 1;
        while (n > 4) {
            n -= 3;
            a *= 3;
        }
        return a * n;
    }
}
