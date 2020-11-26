package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/26
 * Time: 下午4:06
 */
public class _offer_64 {
    public static void main(String[] args) {
        System.out.println(sumNums(2));
    }

    public static int sumNums(int n) {
        // return (int) (Math.pow(n, 2) + n) >> 1;
        // 巧妙利用"短路"特性 当n大于0时 就继续递归 否则停止递归 return 前面的累加值
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
