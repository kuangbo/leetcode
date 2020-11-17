package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/16
 * Time: 下午3:07
 */
public class _28strStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr("mississippi", "issip"));
    }

    public static int strStr(String haystack, String needle) {
        // KMP算法
        if (haystack.equals(needle) || "".equals(needle))
            return 0;
        if ("".equals(haystack) || haystack.length() < needle.length())
            return -1;
        char[] ch = haystack.toCharArray();
        char[] c = needle.toCharArray();
        int i = 0;
        int j = 0;
        for (i = 0; i < ch.length; i++) {
            if (j == c.length) {//判断完成
                return i - c.length;
            }
            if (ch[i] == c[j]) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        if (j == c.length) {//判断完成
            return i - c.length;
        }
        return -1;
    }
}
