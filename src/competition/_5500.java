package competition;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/8/30
 * Time: 上午11:30
 */
public class _5500 {
    public int getMaxLen(int[] nums) {
        if (nums == null)
            return 0;
        int len = nums.length;
        int start = 0;
        int end = 0;
        int maxLen = Integer.MIN_VALUE;
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                flag = false;
                end = i;
                int now = judge(nums, start, end);
                System.out.println(now);
                maxLen = Math.max(maxLen, now);
                start = end + 1;
            }
        }
        if (flag)
            return judge(nums, start, end);
        return maxLen;
    }

    public int judge(int[] nums, int start, int end) {
        int first = start;
        int last = end;
        int count = 0;
        for (int i = start; i < end - start; i++) {
            if (nums[i] < 0) {
                count++;
            }
        }
        for (int i = start; i < end - start; i++) {
            if (nums[i] < 0) {
                first = i;
                break;
            }
        }
        for (int i = end - 1; i >= start; i--) {
            if (nums[i] < 0) {
                last = i;
                break;
            }
        }
        if (count % 2 == 0)
            return end - start;
        return Math.max((end - first - 1), (last - 1 - start));
    }
}
