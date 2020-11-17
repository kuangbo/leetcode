package test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2019/12/25
 * Time: 下午7:52
 */
public class _18fourSum {
    private static Set<List<Integer>> res = new HashSet<>();

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int[] arr = new int[4];
        addSum(arr, nums, target, 0, 0);
        return new ArrayList<>(res);
    }

    private static void addSum(int[] arr, int[] nums, int target, int flag, int iFlag) {
        List<Integer> temp = new ArrayList<>();
        if (flag == 4) {
            int t = 0;
            for (int a : arr) {
                t += a;
            }
            if (target == t) {
                for (int a : arr) {
                    temp.add(a);
                }
                Collections.sort(temp);
                res.add(temp);
            }
        } else {
            for (int i = iFlag; i < nums.length; i++) {
                arr[flag] = nums[i];
                addSum(arr, nums, target, flag + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums, 0));
    }
}
