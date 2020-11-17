package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/23
 * Time: 下午2:38
 */
public class _567checkInclusion {
    public static void main(String[] args) {
        checkInclusion("a", "ab");
    }

    public static boolean checkInclusion(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : ch1)
            need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s2.length()) {
            char c = ch2[right];
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) {  // 当前窗口长度s1长度相等时，返回true
                    return true;
                }
                char d = ch2[left];
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return false;
    }
}
