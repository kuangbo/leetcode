package offer_jianzhi;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/11/29
 * Time: 下午4:15
 */
public class _offer_51 {
    public static void main(String[] args) {
        reversePairs(new int[]{7, 8, 9, 3, 5, 10, 11});
    }

    // 使用归并排序解决逆序对问题
    public static int reversePairs(int[] nums) {
        if (nums.length == 0)
            return 0;
        return merge(nums, 0, nums.length - 1);
    }

    public static int merge(int[] arr, int start, int end) {
        if (start == end)
            return 0;
        int mid = start + (end - start) / 2;
        int count = merge(arr, start, mid) + merge(arr, mid + 1, end);

        int[] temp = new int[end - start + 1];  // 创建新的暂时数组
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            // count += arr[i] <= arr[j] ? j - (mid + 1) : 0;
            // 当i指向的左区间中的数小于等于j指向的右区间的数时，不做处理
            // 当大于时，表示左区间i及i之后的数都将大于j指向的数，所以出现了mid+1-i个逆序对
            count += arr[i] <= arr[j] ? 0 : mid + 1 - i;
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        // mid + 1 - i：相当于对于右区间的每个数字a，找左区间中比a大的有多少，所以如果左区间有剩余，直接复制到暂时数组的后面
        // mid + 1 - i：如果右区间有剩余，表示右区间剩下的数都是比左区间数大的，此时不存在逆序，只需要复制到暂时数组的后面
        // j - (mid + 1)：相当于对于左区间的每个数字b，找右区间中比b小的有多少，所以如果右区间有剩余，直接复制到暂时数组的后面
        // j - (mid + 1)：如果左区间有剩余，表示左区间剩下的数都是比右区间数大的，所以需要在每次放入暂时数组时，加上右区间长度
        while (i <= mid) {
            // count += j - (mid + 1);
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, start, end - start + 1); // 将暂时数组的内容复制到原数组
        return count;
    }
}
