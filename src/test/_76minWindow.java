package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/23
 * Time: 上午11:21
 */
public class _76minWindow {
    public String minWindow(String s, String t) {
        char[] strs = s.toCharArray();
        char[] strt = t.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 将t字符串放入need集合中，并统计字符出现次数
        for (char c : strt)
            need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0;
        int right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始位置及长度
        int start = 0;
        int len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // c是将移入窗口的字符
            char c = strs[right];
            // 右移窗口
            right++;
            // 进行窗口数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            System.out.println("window:[" + left + ", " + right + "]");

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d是将移出窗口的字符
                char d = strs[left];
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列的更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
