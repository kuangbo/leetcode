package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/24
 * Time: 下午5:51
 */
public class _offer_50 {
    public char firstUniqChar(String s) {
        if (s.length() == 0)
            return ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == i && s.indexOf(c, i + 1) == -1)
                return c;
        }
        return ' ';
    }
}
