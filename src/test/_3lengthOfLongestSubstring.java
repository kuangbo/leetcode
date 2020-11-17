package test;

import java.util.HashMap;
import java.util.Map;

class _3lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] chs = s.toCharArray();
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int res = 0;    // 记录结果

        while (right < s.length()) {
            char c = chs[right];
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char d = chs[left];
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            // 在这里更新答案
            res = Math.max(res, right - left);
        }
        return res;
    }
}
