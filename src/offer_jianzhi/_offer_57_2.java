package offer_jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/30
 * Time: 上午10:06
 */
public class _offer_57_2 {
    // 双指针
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int l = 1, r = 2;
        while (l < r) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                list.add(res);
                ++l;
            } else if (sum < target) {
                ++r;
            } else {
                ++l;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
    /*
    // 枚举+数学优化
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for (int x = 1; x <= (target + 1) >> 1; ++x) {
            long delta = 1 - 4 * (x - (long) x * x - 2 * target);
            if (delta < 0) {
                continue;
            }
            int delta_sqrt = (int) Math.sqrt(delta + 0.5);
            if ((long) delta_sqrt * delta_sqrt == delta && ((delta_sqrt - 1) & 1) == 0) {
                int y = (-1 + delta_sqrt) / 2;
                if (x < y) {
                    int[] tempArr = new int[y - x + 1];
                    for (int i = x; i <= y; ++i) {
                        tempArr[i - x] = i;
                    }
                    list.add(tempArr);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
     */
    /*
    // 枚举+暴力
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= (target + 1) >> 1; i++) {
            int sum = i;
            int j = i + 1;
            for (; j <= (target >> 1) + 1; j++) {
                if (sum < target) {
                    sum += j;
                } else {
                    break;
                }
            }
            if (sum == target) {
                int[] tempArr = new int[j - i];
                for (int k = 0; k < tempArr.length; k++) {
                    tempArr[k] = i + k;
                }
                list.add(tempArr);
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
     */
}
