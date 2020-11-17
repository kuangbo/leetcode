package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/10/23
 * Time: 上午11:33
 */
public class _offer_60 {
    public static void main(String[] args) {
        System.out.println(1. / 36 / 6);
        System.out.println(36 * 6);
    }

    public double[] twoSum(int n) {

        double temp = 1. / Math.pow(6, n);
        double[] res = new double[5 * n + 1];
        for (int i = 0; i < (5 * n + 1) / 2 + 1; i++) {
            res[i] = (i + 1) * temp;
            res[5 * n + 1 - i] = (i + 1) * temp;
        }
        return res;
    }
}
