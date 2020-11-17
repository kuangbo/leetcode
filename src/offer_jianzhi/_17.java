package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/17
 * Time: 上午10:51
 */
public class _17 {
    public int[] printNumbers(int n) {
        if (n <= 0)
            return new int[]{};
        StringBuilder sb = new StringBuilder();
        while ((n--) > 0) {
            sb.append('9');
        }
        int max = Integer.parseInt((sb.toString()));
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
