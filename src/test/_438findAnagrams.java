package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/23
 * Time: 下午3:01
 */
public class _438findAnagrams {
    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : chp)
            need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s.length()) {
            char c = chs[right];
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == need.size())
                    res.add(left);
                char d = chs[left];
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return res;
    }
}
