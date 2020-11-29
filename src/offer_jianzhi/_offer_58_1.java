package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/29
 * Time: 下午6:43
 */
public class _offer_58_1 {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].equals(""))
                continue;
            if (i == 0) {
                sb.append(strs[i].trim());
            } else {
                sb.append(strs[i].trim()).append(" ");
            }
        }
        return sb.toString();
    }
}
