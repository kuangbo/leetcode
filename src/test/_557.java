package test;

public class _557 {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int right = 0;
        int left = 0;
        int foot = 0;
        char[] res = new char[len];
        while (left < len && right < len) {
            while (right < len && arr[right] != ' ') {
                right++;
            }
            for (int i = right - 1; i >= left; i--) {
                res[foot++] = arr[i];
            }
            if (foot < len - 1)
                res[foot++] = ' ';
            right++;
            left = right;
        }
        return String.valueOf(res);
    }
}
