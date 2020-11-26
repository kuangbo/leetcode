package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/26
 * Time: 上午10:17
 */
public class _offer_58_2 {
    // 三次反转，空间复杂度O(1)
    // "hello" -> "olleh" -> "lloeh" -> "llohe"
    public String reverseLeftWords(String s, int n) {
        if (s.length() == 0)
            return "";
        if (s.length() <= n)
            return s;
        return s.substring(n) + s.substring(0, n);
    }
}
