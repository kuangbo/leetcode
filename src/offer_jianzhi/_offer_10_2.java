package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2021/3/13
 * Time: 下午5:47
 */
public class _offer_10_2 {
    public static void main(String[] args) {
        System.out.println(numWays(50));
    }
    public static int numWays(int n) {
        int f0 = 1;
        int f1 = 1;
        int f2 = 2;
        if (n == 0)
            return f0;
        if (n == 1)
            return f1;
        if (n == 2)
            return f2;
        int f3 = f1 + f2;
        while (n > 2) {
            f3 = (f1 + f2)  % 1000000007;
            f1 = f2;
            f2 = f3;
            --n;
        }
        return f3;
    }
    public static int numWays1(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        return (numWays(n - 2) + numWays(n - 1)) % 1000000007;
    }
}
