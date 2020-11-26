package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/26
 * Time: 下午6:39
 */
public class _offer_53_1 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,2,3}, 3));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int t = mid;
                while (++t < nums.length && nums[t] == target)
                    res++;
                t = mid;
                while (--t >= 0 && nums[t] == target)
                    res++;
                res++;
                break;
            } else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return res;
    }
}
