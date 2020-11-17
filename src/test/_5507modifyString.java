package test;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/9/6
 * Time: 上午10:50
 */
public class _5507modifyString {
    public static void main(String[] args) {
        System.out.println(modifyString("?"));
    }

    public static String modifyString(String s) {
        if (s == null || "".equals(s))
            return "";
        if (s.length() == 1 && "?".equals(s))
            return "a";
        if (s.length() == 1)
            return s;
        char[] arr = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] ch = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (ch[i] == '?') {
                int foot = -1;
                if (i == 0) {
                    while (ch[i + 1] == arr[++foot]) ;
                    ch[i] = arr[foot];
                } else if (i == len - 1) {
                    while (ch[i - 1] == arr[++foot]) ;
                    ch[i] = arr[foot];
                } else {
                    while (ch[i - 1] == arr[++foot] || ch[i + 1] == arr[foot]) ;
                    ch[i] = arr[foot];
                }
            }
        }
        return String.valueOf(ch);
    }
}
