package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/19
 * Time: 上午8:35
 */
public class _647countSubstrings {
    int res = 0;

    public static void main(String[] args) {

    }

    public int countSubstrings(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            count(ch, i, i);    // 个数为奇数
            count(ch, i, i + 1);    // 个数为偶数
        }
        return res;
    }

    public void count(char[] ch, int start, int end) {
        while (start >= 0 && end < ch.length && ch[start] == ch[end]) {
            res++;
            start--;
            end++;
        }
    }
}
