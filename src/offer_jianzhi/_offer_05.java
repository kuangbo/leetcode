package offer_jianzhi;

public class _offer_05 {
    public static void main(String[] args) {
        System.out.println(replaceSpace("we are happy!"));
    }
    public static String replaceSpace(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            sb.append(c == ' ' ? "%20" : c);
        }
        return sb.toString();
    }
}
