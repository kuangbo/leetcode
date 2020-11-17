package offer_jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/10/23
 * Time: 上午11:06
 */
public class _48 {
    public int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        Map<Character, Integer> window = new HashMap<>();

        int maxlen = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = ch[right];
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char d = ch[left];
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            maxlen = Math.max(maxlen, right - left);
        }
        return maxlen;
    }
}
