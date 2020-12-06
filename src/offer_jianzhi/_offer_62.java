package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/26
 * Time: 下午4:32
 */
public class _offer_62 {
    /*
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
        // 递归解法
        // if (n == 1)
        //     return 0;
        // int x = lastRemaining(n - 1, m);
        // return (m + x) % n;
    }
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;    // 初始化i=2时，ans的值，从2开始反推
        for (int i = 2; i <= n; ++i) {
            ans = (ans + m) % i;    // 更新ans，(ans + m)中的ans表示后一轮的ans值
        }
        return ans;
    }
}
