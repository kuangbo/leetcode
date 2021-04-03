package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/15
 * Time: 下午4:22
 */
public class _offer_16 {
}

class Solution_16 {
    public double myPow1(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n == -1)
            return 1 / x;
        double half = myPow1(x, n / 2);
        double mod = myPow1(x, n % 2);
        return half * half * mod;
    }
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double res = 1.0;
        while (b > 0) {
            if ((b & 1) == 1)
                res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
