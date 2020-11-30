package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/29
 * Time: 下午6:55
 */
public class _offer_65 {
    public int add(int a, int b) {
        while (b != 0) {    // 当进位为0时跳出
            int c = (a & b) << 1;   // c = 进位
            a ^= b; // a = 非进位
            b = c;  // b = 进位
        }
        return a;
    }
}
