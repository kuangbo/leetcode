package offer_jianzhi;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/12/1
 * Time: 上午11:06
 */
public class _offer_61 {
    // 集合set+遍历
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;  // 初始化最大、最小
        for (int num : nums) {
            if (num == 0)   // 跳过0值
                continue;
            max = Math.max(max, num);   // 求数组中的最大值
            min = Math.min(min, num);   // 求数组中的最小值
            if (set.contains(num))  // 判断set集合中是否存在，如果存在说明元素重复，直接返回false
                return false;
            set.add(num);
        }
        return max - min < 5;   // 判断 最大 - 最小 < 5
    }
    // 排序+遍历
    /*
    public boolean isStraight(int[] nums) {
        if (nums.length != 5)
            return false;
        Arrays.sort(nums);
        int num_zero = 0;
        int diff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                ++num_zero;
            } else {
                if (nums[i] == nums[i + 1]) {
                    return false;
                }
                if (nums[i] + 1 != nums[i + 1]) {
                    diff += nums[i + 1] - nums[i] - 1;
                }
            }
        }
        return num_zero >= diff;
    }
     */
}
